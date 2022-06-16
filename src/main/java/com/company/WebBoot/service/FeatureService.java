package com.company.WebBoot.service;

import com.company.WebBoot.model.Features;

import java.util.ArrayList;
import java.util.List;

public interface FeatureService {

    Features getById(Integer id);

    void save(Features features);

    void delete(Integer id);

    List<Features> getAll();

    ArrayList<Features> detail(Integer id);

}
