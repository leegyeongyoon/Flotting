package com.flotting.common.security;

import com.flotting.common.security.jwt.JwtFilter;
import com.flotting.common.security.jwt.JwtTokenProvider;
import com.flotting.common.security.service.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserDetailServiceImpl userDetailService;

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().
//                requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
//                .requestMatchers(new AntPathRequestMatcher("/v3/**"))
//                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**"))
//                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs"))
//                .requestMatchers(new AntPathRequestMatcher( "/swagger-ui/**"))
//                .requestMatchers(new AntPathRequestMatcher( "/swagger-resources/**"))
//                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
//                .requestMatchers(new AntPathRequestMatcher("/css/**"))
//                .requestMatchers(new AntPathRequestMatcher("/js/**"))
//                .requestMatchers(new AntPathRequestMatcher("/img/**"))
//                .requestMatchers(new AntPathRequestMatcher("/lib/**"));
//    }


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement((sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(
                                        new AntPathRequestMatcher("/v3/**"),
                                        new AntPathRequestMatcher("/v3/api-docs/**"),
                                        new AntPathRequestMatcher("/swagger-ui**"),
                                        new AntPathRequestMatcher("/v2/api-docs"),
                                        new AntPathRequestMatcher("/swagger-ui/**"),
                                        new AntPathRequestMatcher("/swagger-resources/**")).permitAll()
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        http.addFilterBefore(new JwtFilter(jwtTokenProvider, userDetailService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}