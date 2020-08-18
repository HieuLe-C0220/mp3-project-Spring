package com.meo.mp3.services.impl;

import com.meo.mp3.models.users.account.Profile;
import com.meo.mp3.repositories.ProfileRepository;
import com.meo.mp3.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> findAll() {
        return (List<Profile>) profileRepository.findAll();
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile save(Profile model) {
        return profileRepository.save(model);
    }

    @Override
    public Profile delete(Long id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        assert profile != null;
        profileRepository.delete(profile);
        return profile;
    }
}
