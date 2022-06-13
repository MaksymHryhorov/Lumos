package com.company.WebBoot.service;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.repository.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeatureServiceImplementation implements FeatureService {

    @Autowired
    FeaturesRepository featuresRepository;

    @Override
    public Features getById(Long id) {
        return null;
    }

    @Override
    public Features save(Features user) {

        return user;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Features> getAll() {
        return null;
    }
}
