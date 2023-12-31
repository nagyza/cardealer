package org.nagyza.cardealer.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username was not entered!")
    private String username;

    @NotBlank(message = "Password was not entered!")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
