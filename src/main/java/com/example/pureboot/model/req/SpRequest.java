package com.example.pureboot.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SpRequest {
    @JsonProperty("spcode")
    private String spCode;
    @JsonProperty("spname")
    private String spName;
}
