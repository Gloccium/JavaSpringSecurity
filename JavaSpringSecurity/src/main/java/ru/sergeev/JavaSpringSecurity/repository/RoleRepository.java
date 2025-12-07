package ru.sergeev.JavaSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sergeev.JavaSpringSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}