package com.idat.remiseriamvc.demo.models.dto;

import lombok.Data;

@Data
public class CreatePaymentDto {
    String username;
    String password;
    String firstName;
    String lastName;
    String address;
    String phone;
    String email;
    Integer idRol;
}
