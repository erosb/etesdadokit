package com.github.erosb.etesdadokit.feature.offer.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erosb.etesdadokit.common.contact.Contact;
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

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransportOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    public void testOk() throws Exception {
        mockMvc.perform(post("/offer/transport/").content(readJson("/transport-offer/testOk.json")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty());
    }

    @Test
    public void testMissingRootMandatoryFields() throws Exception {
        TransportOfferRequest transportOfferRequest = validTransportOfferRequest();

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().cityOnly(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().contact(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().availableFrom(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().refrigeratorCar(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().vehicleCapacity(null).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyRootMandatoryFields() throws Exception {
        TransportOfferRequest transportOfferRequest = validTransportOfferRequest();

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder().vehicleCapacity("").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingContactMandatoryFields() throws Exception {
        TransportOfferRequest transportOfferRequest = validTransportOfferRequest();

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
                                .toBuilder()
                                .email(null)
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
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
        TransportOfferRequest transportOfferRequest = validTransportOfferRequest();

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
                                .toBuilder()
                                .nameOrCompany("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
                                .toBuilder()
                                .email("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/offer/transport/")
                .content(mapper.writeValueAsString(transportOfferRequest.toBuilder()
                        .contact(transportOfferRequest.getContact()
                                .toBuilder()
                                .phoneNumber("")
                                .build()
                        ).build()
                ))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMissingOptionalFields() throws Exception {
        mockMvc.perform(post("/offer/transport/")
                .content(readJson("/transport-offer/testMissingOptionalFields.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private TransportOfferRequest validTransportOfferRequest() {
        return TransportOfferRequest.builder()
                .cityOnly(true)
                .availableFrom(LocalTime.NOON)
                .refrigeratorCar(true)
                .vehicleCapacity("2m3")
                .offerAvailableDate(LocalDate.now())
                .contact(Contact.builder()
                        .email("test@test.hu")
                        .nameOrCompany("Teszt Elek")
                        .phoneNumber("+3650666666")
                        .build())
                .build();
    }
}
