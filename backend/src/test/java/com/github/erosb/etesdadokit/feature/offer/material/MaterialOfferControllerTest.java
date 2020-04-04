package com.github.erosb.etesdadokit.feature.offer.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erosb.etesdadokit.common.address.Address;
import com.github.erosb.etesdadokit.common.contact.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import org.junit.Before;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MaterialOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    public void testMissingRootMandatoryFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder().address(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder().contact(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder().ingredients(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyRootMandatoryFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder().ingredients("").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingContactMandatoryFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
                                .toBuilder()
                                .email(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
                                .toBuilder()
                                .phoneNumber(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyContactMandatoryFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
                                .toBuilder()
                                .email("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .contact(materialOfferRequest.getContact()
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
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .city(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineOne(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
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
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .city("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineOne("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .zip(0)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingOptionalFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder().transportRequest(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineTwo(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testEmptyOptionalFields() throws Exception {
        MaterialOfferRequest materialOfferRequest = validMaterialOfferRequest();

        mockMvc.perform(post("/offer/material/")
                .content(mapper.writeValueAsString(materialOfferRequest.toBuilder()
                        .address(materialOfferRequest.getAddress()
                                .toBuilder()
                                .addressLineTwo("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    private MaterialOfferRequest validMaterialOfferRequest() {
        return MaterialOfferRequest.builder()
                .availableAnytime(true)
                .ingredients("liszt,só")
                .offerAvailableDate(LocalDate.now())
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