package com.example.pureboot.controller;

import com.example.pureboot.model.Sp;
import com.example.pureboot.model.req.SpRequest;
import com.example.pureboot.svc.SpService;
import org.apache.coyote.Response;
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

    @GetMapping("/guy")
    public List<Sp> getAllGuys(){
        return spService.getAllSp();
    }

    @GetMapping("/guy/{id}")
    public ResponseEntity<Sp> getSingleSp(@PathVariable("id") UUID spId){
        Optional<Sp> s = spService.getSpById(spId);
            return ResponseEntity.ok(s.get());

    }

    @PostMapping("/guy")
    public ResponseEntity<String> addGuy(@RequestBody SpRequest reqBody){
        spService.addSp(reqBody.getSpCode(),reqBody.getSpName());
        return ResponseEntity.ok("Done");
    }

    @PatchMapping("/guy/{id}")
    public ResponseEntity<String> updateGuy(@PathVariable("id") UUID spId, @RequestBody SpRequest reqBody){
        spService.updateSpById(spId, reqBody.getSpCode(), reqBody.getSpName());
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/guy/{id}")
    public ResponseEntity<String> deleteGuy(@PathVariable("id") UUID spId){
        spService.removeSp(spId);
        return ResponseEntity.ok("Deleted");
    }

}
