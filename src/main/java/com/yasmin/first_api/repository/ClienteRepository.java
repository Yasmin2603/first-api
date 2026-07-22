package com.yasmin.first_api.repository;

import com.yasmin.first_api.domain.user.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
