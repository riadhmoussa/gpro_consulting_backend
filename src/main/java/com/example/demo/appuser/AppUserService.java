package com.example.demo.appuser;

import com.example.demo.registration.token.ConfirmationToken;
import com.example.demo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }

    @SneakyThrows
    public ResponseEntity<Map<String, Object>> SignUp(AppUser appUser) {
        boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("email already taken");
        }
        String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodePassword);
        appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusYears(50),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("user",appUser);
        object.put("data",appUser);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        object.put("token",token);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> SignIn(String email,String password){
        System.out.println("ResponseEntity");
        System.out.println(email);
        System.out.println(password);
        AppUser userExist = null;
        try {
            userExist  = appUserRepository.findByEmail(email).get();

        }catch (Exception ex){
             userExist = null;
        }
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();

        if(userExist!=null){
            String encodePassword = bCryptPasswordEncoder.encode(password);
            if(bCryptPasswordEncoder.matches(password,userExist.getPassword())){
                String token = UUID.randomUUID().toString();
                ConfirmationToken confirmationToken = new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusYears(50),
                        userExist
                );
                confirmationTokenService.saveConfirmationToken(confirmationToken);

                data.put("user",userExist);
                object.put("data",data);
                object.put("message","success");
                object.put("token",token);
                return new ResponseEntity<>(object, HttpStatus.OK);
            }else{
                data.put("user",null);
                object.put("message",false);
                object.put("status",200);
                object.put("data",null);
                return new ResponseEntity<>(object, HttpStatus.OK);
            }
        }else{
            data.put("user",null);
            object.put("message",false);
            object.put("status",200);
            object.put("data",null);
            return new ResponseEntity<>(object, HttpStatus.OK);
        }


    }


}
