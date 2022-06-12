package com.company.WebBoot.service;

import com.company.WebBoot.model.Features;

import java.util.List;

public interface FeatureService {
    Features getById(Long id);
    void save(Features user);
    void delete(Long id);
    List<Features> getAll();
}
