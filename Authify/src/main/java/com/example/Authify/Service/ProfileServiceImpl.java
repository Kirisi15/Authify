package com.example.Authify.Service;

import com.example.Authify.Repository.UserRepository;
import com.example.Authify.entiry.UserEntity;
import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    // Manual constructor instead of @RequiredArgsConstructor
    public ProfileServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToUserEntity(request);
        newProfile = userRepository.save(newProfile);
        return convertToProfileResponse(newProfile);
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        ProfileResponse response = new ProfileResponse();
        response.setName(newProfile.getName());
        response.setEmail(newProfile.getEmail());
        response.setUserId(newProfile.getUserId());
        response.setIsAccountVerified(newProfile.getIsAccountVerified());
        return response;
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setUserId(UUID.randomUUID().toString());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setIsAccountVerified(false);
        user.setVerifyOtp(null);
        user.setVerifyOtpExpireAt(null);
        user.setResetOtp(null);
        user.setResetOtpExpireAt(null);
        return user;
    }
}
