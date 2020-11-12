package com.airbnb.crud.controller.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Validated
public class CustomerDetails {
    @JsonProperty("first_name") @NotEmpty private String firstName;
    @JsonProperty("last_name") @NotEmpty private String lastName;
    @JsonProperty("email") @NotEmpty private String emailID;
    @JsonProperty("password") @NotEmpty private String password;
    @JsonProperty("photo") @NotEmpty private String photo;
    @JsonProperty("birth_date") @NotEmpty private String birthDate;
    @JsonProperty("gender") @NotEmpty private String gender;
    @JsonProperty("account_status") @NotEmpty private String accountStatus;
    @JsonProperty("card_number") @NotEmpty private String cardNumber;
    @JsonProperty("security_code") @NotEmpty private String securityCode;
    @JsonProperty("name_on_card") @NotEmpty private String nameOnCard;
    @JsonProperty("payment_type") @NotEmpty private String paymentType;
}
