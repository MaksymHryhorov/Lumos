package com.company.WebBoot.service;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.repository.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImplementation implements FeatureService {

    @Autowired
    FeaturesRepository featuresRepository;

    @Override
    public Features getById(Integer id) {
        return featuresRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Features feature) {
        featuresRepository.save(feature);
    }

    @Override
    public void delete(Integer id) {
        featuresRepository.deleteById(id);
    }

    @Override
    public List<Features> getAll() {
        return featuresRepository.findAll();
    }

    @Override
    public ArrayList<Features> detail(Integer id) {

        Optional<Features> features = featuresRepository.findById(id);
        ArrayList<Features> arrayList = new ArrayList<>();

        features.ifPresent(arrayList::add);

        return arrayList;
    }

}
