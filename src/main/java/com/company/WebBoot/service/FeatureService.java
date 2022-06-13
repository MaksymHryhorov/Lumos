package com.company.WebBoot.service;

import com.company.WebBoot.model.Features;

import java.util.List;

public interface FeatureService {
    Features getById(Long id);

    Features save(Features features);

    void delete(Long id);

    List<Features> getAll();
}
