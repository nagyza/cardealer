package org.nagyza.cardealer.dto;

import org.nagyza.cardealer.model.security.Role;
import org.nagyza.cardealer.model.security.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    String username;
    String email;
    Set<String> roles;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet());
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
