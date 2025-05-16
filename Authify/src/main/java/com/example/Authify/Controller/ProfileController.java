package com.example.Authify.Controller;

import com.example.Authify.Service.ProfileService;
import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@RequestBody ProfileRequest request){
        ProfileResponse response = profileService.createProfile(request);
        return response;
    }
}
