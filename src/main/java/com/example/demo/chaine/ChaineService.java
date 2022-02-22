package com.example.demo.chaine;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ChaineService {
    private final ChaineRepository chaineRepository;

    @SneakyThrows
    public ResponseEntity<Map<String, Object>> addChaine(Chaine chaine) {
        chaineRepository.save(chaine);
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("chaine",chaine);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String,Object>> deleteChaine(Long id){
        chaineRepository.deleteById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",null);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String ,Object>> getChaines(){
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",chaineRepository.findAll());
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


}
