package dev.camargo.criptografia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.camargo.criptografia.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
