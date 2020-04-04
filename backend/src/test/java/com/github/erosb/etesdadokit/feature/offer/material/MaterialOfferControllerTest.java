package com.github.erosb.etesdadokit.feature.offer.material;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MaterialOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOk() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readJson("/material-offer/testOk.json")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty());
    }

    @Test
    public void testMissingRootMandatoryFields() throws Exception {
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
    public void testEmptyRootMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyRootMandatoryFields.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingContactMandatoryFields() throws Exception {
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
    public void testEmptyContactMandatoryFields() throws Exception {
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
    public void testMissingAddressMandatoryFields() throws Exception {
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
    public void testEmptyAddressMandatoryFields() throws Exception {
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
    public void testMissingOptionalFields() throws Exception {
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
    public void testEmptyOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/material/")
                .content(readJson("/material-offer/testEmptyOptionalFields_address_addressLineTwo.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
