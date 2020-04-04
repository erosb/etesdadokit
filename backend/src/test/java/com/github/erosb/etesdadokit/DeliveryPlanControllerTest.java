package com.github.erosb.etesdadokit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeliveryPlanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void simple() throws Exception {
        mockMvc.perform(post("/delivery-plan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readJson("/delivery-plan/complex.json")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void complex() throws Exception {
//        MockHttpSession session = (MockHttpSession) mockMvc.perform(formLogin("/login").user("admin").password("admin"))
//                        .andExpect(redirectedUrl("/"))
//                        .andExpect(status().is3xxRedirection())
//                        .andReturn().getRequest().getSession();


        mockMvc.perform(post("/delivery-plan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readJson("/delivery-plan/complex.json")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
