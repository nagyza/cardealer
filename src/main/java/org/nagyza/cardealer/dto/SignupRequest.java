package org.nagyza.cardealer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupRequest {

    @NotBlank(message = "The username is mandatory for registration!")
    @Size(min = 1, max = 50, message = "The username must be be between 1 and 20 character(s)!")
    private String username;
    @NotBlank(message = "The email is mandatory for registration!")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Add a valid email address, please!")
    private String email;

    @NotBlank(message = "The password is mandatory for registration!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
            message = "The password must contain digits, lower case characters and upper case characters and must be at least 8 character long!")
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
