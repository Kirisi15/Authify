package com.example.Authify.Controller;

import com.example.Authify.Service.ProfileService;
import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfileController {

    private final ProfileService profileService;

    // Constructor manually added (instead of @RequiredArgsConstructor)
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@RequestBody ProfileRequest request) {
        return profileService.createProfile(request);
    }
}
