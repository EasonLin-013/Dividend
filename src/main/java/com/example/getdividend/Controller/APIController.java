package com.example.getdividend.Controller;

import com.example.getdividend.Entity.ApiCode;
import com.example.getdividend.Service.getUrlService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;  //不能用這個，要使用org.springframework.web.bind.annotation.RequestBody，不然@RequestBody 會抓不到值導致都是NULL
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Tag(name = "API")
@RestController
//@Controller
public class APIController {
//    @RequestMapping(value = "/APIGET", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//@GetMapping("/APIPOST")
//@PostMapping("/APIPOST")
    @RequestMapping(value = "/APIPOST", method = RequestMethod.POST)
    public String get(@RequestBody ApiCode apiCode) throws IOException, InterruptedException {
//        String str = "測試";
        getUrlService getUrl = new getUrlService();
//        String aa = gett.getUrl(str);
        String response = getUrl.getUrl(apiCode);
//        return apiCode.toString();
        return response;
    }
}
