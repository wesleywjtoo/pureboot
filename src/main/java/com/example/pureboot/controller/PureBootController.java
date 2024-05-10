package com.example.pureboot.controller;

import com.example.pureboot.model.Sp;
import com.example.pureboot.model.req.SpRequest;
import com.example.pureboot.svc.SpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PureBootController {

    private SpService spService;

    public PureBootController(SpService spService){
        this.spService = spService;
    }


    @GetMapping("/sp")
    public List<Sp> getAllSp(){
        return spService.getAllSp();
    }

    @GetMapping("/sp/{id}")
    public ResponseEntity<Sp> getSingleSp(@PathVariable("id") UUID spId){
        Optional<Sp> s = spService.getSpById(spId);
            return ResponseEntity.ok(s.get());

    }

    @PostMapping("/sp")
    public ResponseEntity<String> addSp(@RequestBody SpRequest reqBody){
        System.out.println(reqBody);
        spService.addSp(reqBody.getSpCode(),reqBody.getSpName());
        return ResponseEntity.ok("Done");
    }

    @PatchMapping("/sp/{id}")
    public ResponseEntity<String> updateSp(@PathVariable("id") UUID spId, @RequestBody SpRequest reqBody){
        spService.updateSpById(spId, reqBody.getSpCode(), reqBody.getSpName());
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/sp/{id}")
    public ResponseEntity<String> deleteSp(@PathVariable("id") UUID spId){
        spService.removeSp(spId);
        return ResponseEntity.ok("Deleted");
    }

}
