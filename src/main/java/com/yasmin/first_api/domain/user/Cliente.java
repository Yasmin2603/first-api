package com.yasmin.first_api.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
@Entity(name = "users")
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    private String name;

    private LocalDateTime createdAt;
}
