package com.example.demo.registration;

import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/auth/registration", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class RegostrationController {

    private RegistrationService registrationService;
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<Map<String, Object>> register (@RequestBody RegistrationRequest request)  {
        return registrationService.register(request);
    }
}
