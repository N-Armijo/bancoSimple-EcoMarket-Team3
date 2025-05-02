package com.proyectoinregrador.bancosimpleecomarketteam3.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class WebSecurityConfig {


    private UserDetailsServiceImpl userDetailsService;
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authorizeHttpRequests(auth -> auth
                                //Login y Registro
                                .requestMatchers("/api/auth/**").permitAll()
                                //Categories
                                .requestMatchers("/categories/list").permitAll()
                                .requestMatchers("/categories/**").hasAuthority("ADMIN")
                                //Comuna
                                .requestMatchers("/comunes/list").permitAll()
                                .requestMatchers("/comunes/**").hasAuthority("ADMIN")
                                //Pais
                                .requestMatchers("/countries/list").permitAll()
                                .requestMatchers("/countries/**").hasAuthority("ADMIN")
                                //Detalle del producto
                                .requestMatchers("/detailorders/new").permitAll()
                                .requestMatchers("/detailorders/list").permitAll()//Modificar por id usuario
                                .requestMatchers("/detailorders/detailorder/**").permitAll()//Modificar por id usuario
                                .requestMatchers("/detailorders/**").hasAuthority("ADMIN")
                                //Dirección
                                .requestMatchers("/directions/list").permitAll()
                                .requestMatchers("/directions/**").hasAuthority("ADMIN")
                                //Orden Productos
                                .requestMatchers("/orderproducts/orderproduct/**").permitAll()//Modificar por id usuario
                                .requestMatchers("/orderproducts/new").permitAll()
                                .requestMatchers("/orderproducts/edit").permitAll()//Modificar por id usuario
                                .requestMatchers("/orderproducts/**").hasAuthority("ADMIN")
                                //Productos
                                .requestMatchers("/products/list").permitAll()
                                .requestMatchers("/products/product/**").permitAll()
                                .requestMatchers("/products/**").hasAnyAuthority("VENDEDOR","ADMIN")//Modificar por id usuario
                                //Region
                                .requestMatchers("/regions/list").permitAll()
                                .requestMatchers("/regions/**").hasAuthority("ADMIN")
                                //Usuarios
                                .requestMatchers("/users/edit").permitAll()//Modificar por id usuario
                                .requestMatchers("/users/userEmail").hasAnyAuthority("VENDEDOR","COMPRADOR","BANK")
                                .requestMatchers("/users/**").hasAuthority("ADMIN")
                                .requestMatchers("/swagger-ui.html","/swagger-ui/**", "/api-docs", "/api-docs/**").permitAll()
                                //Banco
                                .requestMatchers("/accounts/**").hasAuthority("BANK")
                                .requestMatchers("/transactions/**").hasAuthority("BANK")
                                .requestMatchers("/cards/**").hasAuthority("BANK")
                                .requestMatchers("/be-pass/**").hasAuthority("BANK")
                                .requestMatchers("/tickets/**").hasAuthority("BANK")
                                .requestMatchers("/desctickets/**").hasAuthority("BANK")


                                .anyRequest().authenticated()

                        );
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
