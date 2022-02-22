package com.example.demo.registration;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class RegistrationService {


    private final AppUserService appUserService;

    public ResponseEntity<Map<String, Object>> register(RegistrationRequest request) {
        return appUserService.SignUp(
                new AppUser(
                        request.getNom(),
                        request.getPrenom(),
                        request.getEmail(),
                        request.getPassword()
                )
        );
    }
}
