package com.example.pureboot.controller;

import com.example.pureboot.model.Sp;
import com.example.pureboot.svc.SpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PureBootController {

    private SpService spService;

    public PureBootController(SpService spService){
        this.spService = spService;
    }

    @GetMapping("/guy")
    public List<Sp> getAllGuys(){
        return spService.getAllSp();
    }

}
