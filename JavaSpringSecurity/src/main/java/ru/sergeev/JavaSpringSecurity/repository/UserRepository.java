package ru.sergeev.JavaSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sergeev.JavaSpringSecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}