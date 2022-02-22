package com.example.demo.chaine;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/user/chaine", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class ChaineController {
    private ChaineService chaineService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> addChaine (@RequestBody Chaine request){
        return chaineService.addChaine(request);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getChaines (){
        return chaineService.getChaines();
    }


}
