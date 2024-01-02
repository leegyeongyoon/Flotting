package com.flotting.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenUser {

    private String id;

    private String name;

    public static TokenUser defaultUser() {
        return new TokenUser("id", "defaultUser");
    }
}
