package com.example.pureboot.svc;

import com.example.pureboot.model.Sp;
import com.example.pureboot.repo.PureBootRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpService {
    @Autowired
    private PureBootRepo pureBootRepo;

    public List<Sp> getAllSp(){
        Sort spSort = Sort.by("dateJoin").ascending();
        return pureBootRepo.findAll(spSort);
    }

    public Optional<Sp> getSpById(UUID spId){
        Optional<Sp> s = pureBootRepo.findById(spId);
        return s;
    }

    public void updateSpById(UUID spId, String spCode, String spName){
        Optional<Sp> s = getSpById(spId);
        if(s.isPresent()){
            s.get().setSpCode(spCode);
            s.get().setSpName(spName);
            s.get().setDateJoin(LocalDateTime.now());
            pureBootRepo.save(s.get());
        }
    }

    public void addSp(String spCode,String spName){
        Sp o = Sp.builder().spId(UUID.randomUUID())
                .spCode(spCode).spName(spName).dateJoin(LocalDateTime.now())
                .build();
        System.out.println("add Sp Service");
        System.out.println(o);
        pureBootRepo.save(o);
    }

    public void removeSp(UUID spId){
        Optional<Sp> s = getSpById(spId);
        if(s.isPresent()) {
            pureBootRepo.deleteById(spId);
        }
    }
}
