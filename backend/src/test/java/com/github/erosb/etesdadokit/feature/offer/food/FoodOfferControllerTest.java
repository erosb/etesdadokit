package com.github.erosb.etesdadokit.feature.offer.food;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import com.github.erosb.etesdadokit.common.address.Address;
import com.github.erosb.etesdadokit.common.contact.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FoodOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    @Ignore("TODO mapper.readValue is not working")
    public void testWithAllFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        String response = mockMvc.perform(post("/offer/food/").content(mapper.writeValueAsString(foodOfferRequest)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        AcknowledgeResponse resp = mapper.readValue(response, AcknowledgeResponse.class);

        mockMvc.perform(get("/offer/food/").content(mapper.writeValueAsString(foodOfferRequest)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[1].id").value(resp.getId()))
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
    public void testMissingRootMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().address(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().contact(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().ingredients(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().name(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().quantity(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().transportDate(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyRootMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().ingredients("").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().name("").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().quantity(0).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingContentMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .email(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .phoneNumber(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyContentMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .email("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .contact(foodOfferRequest.getContact()
                                .toBuilder()
                                .phoneNumber("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingAddressMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .city(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineOne(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .zip(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyAddressMandatoryFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .city("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineOne("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .zip(0)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testOptionalFields() throws Exception {
        FoodOfferRequest foodOfferRequest = validFoodRequest();

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder().transportRequest(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/food/")
                .content(mapper.writeValueAsString(foodOfferRequest.toBuilder()
                        .address(foodOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineTwo(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private FoodOfferRequest validFoodRequest() {
        return FoodOfferRequest.builder()
                .name("Pizza")
                .ingredients("liszt,tojas")
                .transportDate(LocalDate.now())
                .quantity(50)
                .contact(Contact.builder()
                        .email("test@test.hu")
                        .nameOrCompany("Teszt Elek")
                        .phoneNumber("+3650666666")
                        .build())
                .address(Address.builder()
                        .addressLineOne("Liget utca 666")
                        .addressLineTwo("5. épület")
                        .city("Győr")
                        .zip(9025)
                        .build())
                .transportRequest(TransportRequest.builder()
                        .requestRefrigeratorCar(true)
                        .requestVehicleCapacity("2 láda")
                        .timeToPickUp(LocalTime.now())
                        .build())
                .build();
    }
}
