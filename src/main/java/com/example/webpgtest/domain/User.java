package com.example.webpgtest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Pattern(regexp = "[A-Z][a-z]+", message = "Must start with a capital letter followed by one or more lowercase letters")
//    @Column(unique = true, nullable = false)
    private String login;

//    private String password;

//    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address")
    private String email;

//    @Enumerated(EnumType.STRING)
//    private Role role;

}
