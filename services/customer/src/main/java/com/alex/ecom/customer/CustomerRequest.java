package com.alex.ecom.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (
    String id,
    @NotNull(message = "required")
    String  firstname,
    @NotNull(message = "required")
    String lastname,
    @NotNull(message = "required")
    @Email(message = "not valid")
    String email,
    Address address
) {

}
