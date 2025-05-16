package com.example.Authify.Service;

import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;

public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest request);
}
