package com.example.getdividend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiCode {
    private String code;
    private String modelProperty;
    private String code_hh;
    @JsonProperty(value = "ModelName")
    private String ModelName; //不可用此命名方式，會取不到值，或是使用註解 @JsonProperty(value = "ModelName")
//    private String Aaaa; //不可用此命名方式，會取不到值，或是使用註解
}