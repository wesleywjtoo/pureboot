package com.example.pureboot.svc;

import com.example.pureboot.model.Sp;
import com.example.pureboot.repo.PureBootRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpService {
    @Autowired
    private PureBootRepo pureBootRepo;

    public List<Sp> getAllSp(){
        return pureBootRepo.findAll();
    }
}
