package com.github.erosb.etesdadokit.feature.offer.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erosb.etesdadokit.common.contact.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.github.erosb.etesdadokit.JsonReader.readJson;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransportOfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    @DirtiesContext
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
                .offerAvailableDate(LocalDate.parse("2020-03-04"))
                .contact(Contact.builder()
                        .email("test@test.hu")
                        .nameOrCompany("Teszt Elek")
                        .phoneNumber("+3650666666")
                        .build())
                .build();
    }

    @Nested
    class GETTest {

        @Test
        void testGet() throws Exception {
            TransportOfferRequest transportOffer1 = validTransportOfferRequest().toBuilder()
                    .offerAvailableDate(LocalDate.of(2020, 2, 2))
                    .build();

            mockMvc.perform(post("/offer/transport").contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(transportOffer1))).andExpect(status().isOk());

            TransportOfferRequest transportOffer2 = validTransportOfferRequest().toBuilder()
                    .offerAvailableDate(LocalDate.of(2020, 3, 3))
                    .build();

            mockMvc.perform(post("/offer/transport").contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(transportOffer2))).andExpect(status().isOk());

            mockMvc.perform(get("/offer/transport?day=2020-02-02"))
                    .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(1)));

            mockMvc.perform(get("/offer/transport"))
                    .andExpect(status().isOk()).andExpect(jsonPath("$.length()", equalTo(2)));

            mockMvc.perform(get("/offer/transport/page?pageNumber=0&pageSize=5"))
                    .andExpect(status().isOk()).andExpect(status().isOk())
                    .andExpect(jsonPath("content").isNotEmpty());

            mockMvc.perform(get("/offer/transport/page"))
                    .andExpect(status().isOk()).andExpect(status().isOk())
                    .andExpect(jsonPath("content").isNotEmpty());
        }

    }
}
