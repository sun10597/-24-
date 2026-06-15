package org.example.securityexam.security4.repository;

import org.example.securityexam.security4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
