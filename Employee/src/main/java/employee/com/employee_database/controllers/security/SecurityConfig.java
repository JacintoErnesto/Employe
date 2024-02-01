/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.controllers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author jacinto
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeRequests()
//                .antMatchers("/conta/contaSalvar").permitAll()
//                .antMatchers("/produto/produtoListar").permitAll()
//                .antMatchers("/produto/produtoSalvar").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
       
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrfCustomizer -> csrfCustomizer.disable())
                .build();
    }
}
