package com.flotting.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenUser {

    /**
     * TODO 토큰 정보도 같이 있으면 좋을듯
     */

    private Long userNo;

    private String name;

    public static TokenUser defaultUser() {
        return new TokenUser(0L, "defaultUser");
    }
}
