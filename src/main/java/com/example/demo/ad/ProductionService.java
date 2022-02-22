package com.example.demo.ad;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class ProductionService {

    private final ProductionRepository adRepository;

    @SneakyThrows
    public ResponseEntity<Map<String, Object>> addAd(Production ad) {
        adRepository.save(ad);
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("production",ad);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String,Object>> deleteAd(Long id){
        adRepository.deleteById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",null);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> getAdById(Long id){
        HashMap<String, Object> object = new HashMap<>();
        Production ad = adRepository.findById(id).get();
        HashMap<String, Object> data = new HashMap<>();
        data.put("production",ad);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

 /*   public ResponseEntity<Map<String,Object>> getAdByUserId(Long id){
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        List ads = adRepository.getAdByUserId(id.toString());
        System.out.println("data production");
        System.out.println(ads);
        System.out.println(id);
        object.put("data",ads);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }*/

    public ResponseEntity<Map<String ,Object>> getProductions(){
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",adRepository.findAll());
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
    public ResponseEntity<Map<String ,Object>> updateUp(Long id, Production ad){
        Production ad_update = adRepository.findById(id).get();
        ad_update = ad;
        adRepository.saveAndFlush(ad_update);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",ad_update);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
    public ResponseEntity<Map<String ,Object>> searchAd(Long id, Production ad){
        Production ad_update = adRepository.findById(id).get();
        ad_update = ad;
        adRepository.saveAndFlush(ad_update);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",ad_update);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }




}
