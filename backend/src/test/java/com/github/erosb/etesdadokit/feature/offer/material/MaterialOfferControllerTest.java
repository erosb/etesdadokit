package com.github.erosb.etesdadokit.feature.offer.material;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.time.LocalDate;

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MaterialOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testOk() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readJson("/material-offer/testOk.json")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty());
    }

    @Test
    void testMissingRootMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingMandatoryFields-address.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingMandatoryFields-contact.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingMandatoryFields-ingredients.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyRootMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyRootMandatoryFields.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingContactMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingContactMandatoryFields-nameOrCompany.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingContactMandatoryFields-email.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingContactMandatoryFields-phoneNumber.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyContactMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyContactMandatoryFields-nameOrCompany.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyContactMandatoryFields_contact_email.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyContactMandatoryFields_contact_phoneNumber.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingAddressMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingAddressMandatoryFields_address_city.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingAddressMandatoryFields_address_addressLineOne.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingAddressMandatoryFields_address_zip.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyAddressMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyAddressMandatoryFields_address_city.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyAddressMandatoryFields_address_addressLineOne.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyAddressMandatoryFields_address_zip_0.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingOptionalFields_transportRequest.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingOptionalFields_offerAvailableDate.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testMissingOptionalFields_address_addressLineTwo.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testEmptyOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyOptionalFields_address_addressLineTwo.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testFindAndFilterByDate() throws Exception {
        MaterialOfferRequest offer1 = mapper.readerFor(MaterialOfferRequest.class).readValue(getClass().
                getResourceAsStream("/material-offer/testOk.json"));
        offer1 = offer1.toBuilder().offerAvailableDate(LocalDate.parse("2020-03-04")).build();

        MaterialOfferRequest offer2 = offer1.toBuilder().offerAvailableDate(LocalDate.parse("2020-03-05")).build();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(offer1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(offer2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/offer/material?day=2020-03-04")).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(1)));

        mockMvc.perform(get("/offer/material")).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(2)));

    }

}
