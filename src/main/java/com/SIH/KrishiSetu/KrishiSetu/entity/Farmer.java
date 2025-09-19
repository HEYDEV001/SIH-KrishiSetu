package com.SIH.KrishiSetu.KrishiSetu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Farmer implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private long mobileNumber;


    private String email;

    @Column(nullable = false)
    private int age ;

    @Column(nullable = false)
    private String address;

    private Long farmSize;

    @Column(nullable = false)
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}


