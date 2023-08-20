package org.nagyza.cardealer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptTest {

    @Test
    public void encryptPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encoded = passwordEncoder.encode("pp");
        System.out.println(encoded);
    }





}
