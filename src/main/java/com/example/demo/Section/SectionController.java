package com.example.demo.Section;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/user/section", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class SectionController {
    private SectionService sectionService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> addSection (@RequestBody Section request){
        return sectionService.addSection(request);
    }

    @GetMapping
        public ResponseEntity<Map<String, Object>> getSections (){
        return sectionService.getSections();
    }


}
