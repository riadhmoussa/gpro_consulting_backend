package com.example.demo.Section;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    @SneakyThrows
    public ResponseEntity<Map<String, Object>> addSection(Section chaine) {
        sectionRepository.save(chaine);
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("section",chaine);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String,Object>> deleteSection(Long id){
        sectionRepository.deleteById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",null);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String ,Object>> getSections(){
        HashMap<String, Object> object = new HashMap<>();
        object.put("data", sectionRepository.findAll());
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


}
