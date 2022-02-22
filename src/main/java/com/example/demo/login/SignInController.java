package com.example.demo.login;


import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "api/auth/signin", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class SignInController {

    private SignInService signInService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> signin (@RequestBody SignInRequest request){
        return signInService.signin(request);
    }


}
