package com.idat.remiseriamvc.demo.models.responses;

import com.idat.remiseriamvc.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

//estructura de respuesta de la authenticacion
@Data
@AllArgsConstructor
public class AuthenticationResponse {
     private String jwt;

     private User user;

}
