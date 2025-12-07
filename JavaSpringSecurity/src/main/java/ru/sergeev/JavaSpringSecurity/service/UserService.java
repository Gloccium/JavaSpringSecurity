package ru.sergeev.JavaSpringSecurity.service;

import ru.sergeev.JavaSpringSecurity.dto.UserDto;
import ru.sergeev.JavaSpringSecurity.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}