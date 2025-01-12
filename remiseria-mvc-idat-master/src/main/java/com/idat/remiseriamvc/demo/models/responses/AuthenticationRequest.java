package com.idat.remiseriamvc.demo.models.responses;

import lombok.Data;

// clase de estructura de la autenticacion
@Data
public class AuthenticationRequest {
     private String username;
     private String password;
}
