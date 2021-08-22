package com.loizenai.jwtauthentication.message.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.validation.constraints.*;

public class RequestPasswordForm {
    
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}
