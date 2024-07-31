package com.example.getdividend.Service;

import com.example.getdividend.Entity.ApiCode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class getUrlService {
        public String getUrl(@RequestBody ApiCode ParamsCode) throws IOException, InterruptedException {
//        String aa = str;
        String url = "https://openapi.twse.com.tw/v1/exchangeReport/TWT48U_ALL";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        // 發送GET請求
        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        // 解析和處理回應
        int getStatusCode = getResponse.statusCode();
        HttpHeaders getHeaders = getResponse.headers();
        String getResponseBody = getResponse.body();

        Gson gson = new Gson();
//        gson.fromJson(getResponseBody);
        List<Data> list = gson.fromJson(getResponseBody,new TypeToken<List<Data>>(){}.getType());

        String Date;
        String Code;
        String Name;
        String Exdividend;
        double StockDividendRatio;
        double CashDividend;
//        String[] words = {"00940","1101","1215","2881","2889","2356","2357","3706","4938"};
//      //ParamsCode.getCode() //"00940,1101,1215,2881,2889,2356,2357,3706,4938"
        String[] words = ParamsCode.getCode().split(",");
        String str = "";
        for (Data data : list) {
            Code = data.Code;
            if (containsWords(Code, words)) {
                Date = data.Date.substring(0, 3) + "/" + data.Date.substring(3, 5) + "/" + data.Date.substring(5, 7);
                Name = data.Name;
                Exdividend = data.Exdividend;
                StockDividendRatio = Double.parseDouble(data.StockDividendRatio.isEmpty() ? "0" : data.StockDividendRatio);
                CashDividend = Double.parseDouble(data.CashDividend.isEmpty() ? "0" : data.CashDividend);
                str += "Date:" + Date + "\tCode:" + Code + "\tName:" + Name + "\n" + "Exd:" + Exdividend + "\t\t\tStock:" + StockDividendRatio + "\tCash:" + CashDividend + "\n" + "———————————————————————————————————————————————————\n";
            }
        }

        return str;
    }

    public static class Data{
        String Date;
        String Code;
        String Name;
        String Exdividend;
        String StockDividendRatio;
        String CashDividend;
    }

    public static boolean containsWords(String inputString, String[] items) {
        boolean found = false;
        for (String item : items) {
            if (inputString.equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
