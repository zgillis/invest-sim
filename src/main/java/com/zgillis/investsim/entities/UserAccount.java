package com.zgillis.investsim.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("hidden")
@Entity(name = "users")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, unique = true, nullable = false)
    private String username;

    @Column(length = 50)
    private String password;

    @Column(length = 35)
    private String firstName;

    @Column(length = 35)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String phone;

}
