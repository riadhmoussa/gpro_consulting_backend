package com.example.demo.ad;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping(path = "api/user/production", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class ProductionController {

    private ProductionService adService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> addAd (@RequestBody Production request){
        return adService.addAd(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteAd (@PathVariable(value = "id") Long id){
        return adService.deleteAd(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAdById (@PathVariable(value = "id") Long id){
        return adService.getAdById(id);
    }

 /*   @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getAdByUserId (@PathVariable(value = "id") Long id){
        return adService.getAdByUserId(id);
    }*/

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAds (){
        return adService.getProductions();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAd (@PathVariable(value = "id") Long id,@RequestBody Production request){
        return adService.updateUp(id,request);
    }


}
