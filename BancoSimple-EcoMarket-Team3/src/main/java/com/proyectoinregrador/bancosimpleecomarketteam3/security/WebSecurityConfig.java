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
                                .requestMatchers("/categories/**").hasAuthority("ADMIN")
                                .requestMatchers("/categories/list").permitAll()
                                //Comuna
                                .requestMatchers("/comunes/**").hasAuthority("ADMIN")
                                .requestMatchers("/comunes/list").permitAll()
                                //Pais
                                .requestMatchers("/countries/**").hasAuthority("ADMIN")
                                .requestMatchers("/countries/list").permitAll()
                                //Detalle del producto
                                .requestMatchers("/detailorders/**").hasAuthority("ADMIN")
                                .requestMatchers("/detailorders/new").permitAll()
                                .requestMatchers("/detailorders/list").permitAll()//Modificar por id usuario
                                .requestMatchers("/detailorders/detailorder/**").permitAll()//Modificar por id usuario
                                //Dirección
                                .requestMatchers("/directions/**").hasAuthority("ADMIN")
                                .requestMatchers("/directions/list").permitAll()
                                //Orden Productos
                                .requestMatchers("/orderproducts/**").hasAuthority("ADMIN")
                                .requestMatchers("/orderproducts/orderproduct/**").permitAll()//Modificar por id usuario
                                .requestMatchers("/orderproducts/new").permitAll()
                                .requestMatchers("/orderproducts/edit").permitAll()//Modificar por id usuario
                                //Productos
                                .requestMatchers("/products/**").hasAuthority("ADMIN")
                                .requestMatchers("/products/**").hasAuthority("VENDEDOR")//Modificar por id usuario
                                .requestMatchers("/products/list").permitAll()
                                .requestMatchers("/products/product/**").permitAll()
                                //Region
                                .requestMatchers("/regions/**").hasAuthority("ADMIN")
                                .requestMatchers("/regions/list").permitAll()
                                //Usuarios
                                .requestMatchers("/users/**").hasAuthority("ADMIN")
                                .requestMatchers("/users/edit").permitAll()//Modificar por id usuario
                                .requestMatchers("/swagger-ui.html","/swagger-ui/**", "/api-docs", "/api-docs/**").permitAll()
                                .anyRequest().authenticated()

                        );
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
