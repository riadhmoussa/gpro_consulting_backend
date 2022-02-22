package com.example.demo.login;


import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import com.example.demo.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class SignInService {


    private final AppUserService appUserService;

    public ResponseEntity<Map<String, Object>> signin(SignInRequest request) {
        System.out.println(request);
        return appUserService.SignIn(request.getEmail(),request.getPassword());
    }


}
