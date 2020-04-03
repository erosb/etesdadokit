package com.github.erosb.etesdadokit.model;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class FoodOfferingDTO {

    private Long id;

    private String name;

    private Integer portion;

    private Date deliveryDate;

    private String notes;

    private Boolean needTransport;

    private String address;

    private List<ContactInfo> contactInfo;
}
