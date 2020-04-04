package com.github.erosb.etesdadokit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeliveryPlanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test() throws Exception {
//        MockHttpSession session = (MockHttpSession) mockMvc.perform(formLogin("/login").user("admin").password("admin"))
//                        .andExpect(redirectedUrl("/"))
//                        .andExpect(status().is3xxRedirection())
//                        .andReturn().getRequest().getSession();


        mockMvc.perform(post("/delivery-plan")
                .header("Content-Type", "application/json")
                .content(readJson("/delivery-plan.json")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
