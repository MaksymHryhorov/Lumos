package com.company.WebBoot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.repository.FeaturesRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;


@SpringBootTest
@AutoConfigureMockMvc
class WebBootApplicationTest {

    @Autowired
    FeaturesRepository featuresRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void httpFeatureAdd() throws Exception {
        this.mockMvc.perform(get("/feature/add")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void httpDefault() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void httpFeatures() throws Exception {
        this.mockMvc.perform(get("/features")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void httpFeaturesId() throws Exception {
        Iterable<Features> iterable = featuresRepository.findAll();
        ArrayList<Features> arrayList = new ArrayList<>();

        iterable.forEach(arrayList::add);

        Features features1 = arrayList.get(0);


        this.mockMvc.perform(get("/features/" + features1.getId())).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void httpFeaturesIdEdit() throws Exception {
        Iterable<Features> iterable = featuresRepository.findAll();
        ArrayList<Features> arrayList = new ArrayList<>();

        iterable.forEach(arrayList::add);

        Features features1 = arrayList.get(0);


        this.mockMvc.perform(get("/features/" + features1.getId() + "/edit")).andDo(print()).andExpect(status().isOk());
    }
}
