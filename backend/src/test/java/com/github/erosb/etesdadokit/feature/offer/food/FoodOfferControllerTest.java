package com.github.erosb.etesdadokit.feature.offer.food;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
public class FoodOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testOk() throws Exception {
        mockMvc.perform(post("/offer/food/").content(readJson("/food-offer/testOk.json")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty());
    }

    @Test
    @Disabled("TODO mapper.readValue is not working")
    void testWithAllFields() throws Exception {
        String response = mockMvc.perform(post("/offer/food/").content(readJson("/food-offer/testOk.json")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

//   TODO     AcknowledgeResponse resp = mapper.readValue(response, AcknowledgeResponse.class);

        mockMvc.perform(get("/offer/food/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//     TODO           .andExpect(jsonPath("[1].id").value(resp.getId()))
                .andExpect(jsonPath("[1].name").value("Pizza"))
                .andExpect(jsonPath("[1].quantity").value("50"))
                .andExpect(jsonPath("[1].transportDate").value("2020-04-04"))
                .andExpect(jsonPath("[1].ingredients").value("liszt,tojas"))
                .andExpect(jsonPath("[1].transportRequest.timeToPickUp").value("13:07"))
                .andExpect(jsonPath("[1].transportRequest.requestVehicleCapacity").value("2 láda"))
                .andExpect(jsonPath("[1].transportRequest.requestRefrigeratorCar").value("true"))
                .andExpect(jsonPath("[1].address.city").value("Győr"))
                .andExpect(jsonPath("[1].address.zip").value("9025"))
                .andExpect(jsonPath("[1].address.addressLineOne").value("Liget utca 666"))
                .andExpect(jsonPath("[1].address.addressLineTwo").value("5. épület"))
                .andExpect(jsonPath("[1].contact.nameOrCompany").value("Teszt Elek"))
                .andExpect(jsonPath("[1].contact.email").value("test@test.hu"))
                .andExpect(jsonPath("[1].contact.phoneNumber").value("+3650666666"));

    }

    @Test
    void testMissingRootMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingRootMandatoryFields_address.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingRootMandatoryFields_contact.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingRootMandatoryFields_ingredients.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingRootMandatoryFields_name.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingRootMandatoryFields_quantity.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyRootMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyRootMandatoryFields_ingredients.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyRootMandatoryFields_name.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyRootMandatoryFields_quantity_0.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingContactMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingContactMandatoryFields_contact_nameOrCompany.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingContactMandatoryFields_contact_email.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingContactMandatoryFields_contact_phoneNumber.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyContactMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyContactMandatoryFields_contact_nameOrCompany.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyContactMandatoryFields_contact_email.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyContactMandatoryFields_contact_phoneNumber.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingAddressMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingAddressMandatoryFields_address_city.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingAddressMandatoryFields_address_addressLineOne.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingAddressMandatoryFields_address_zip.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testEmptyAddressMandatoryFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyAddressMandatoryFields_address_city.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyAddressMandatoryFields_address_addressLineOne.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyAddressMandatoryFields_address_zip_0.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingOptionalFields_transportRequest.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingOptionalFields_transportRequest.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testMissingOptionalFields_contact_addressLineTwo.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testEmptyOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/food/")
                .content(readJson("/food-offer/testEmptyOptionalFields_address_addressLineTwo.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void testFindAndFilterByDate() throws Exception {
        FoodOfferRequest offer1 = mapper.readerFor(FoodOfferRequest.class).readValue(
                getClass().getResourceAsStream("/food-offer/testOk.json"));
        offer1 = offer1.toBuilder().transportDate(LocalDate.parse("2020-03-04")).build();

        FoodOfferRequest offer2 = offer1.toBuilder().transportDate(LocalDate.parse("2020-03-05")).build();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(offer1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(offer2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/offer/food?day=2020-03-04"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(1)));

        mockMvc.perform(get("/offer/food"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(2)));
    }
}
