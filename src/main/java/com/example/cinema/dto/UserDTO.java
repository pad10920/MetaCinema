package com.example.cinema.dto;

import com.example.cinema.mapper.UserMapper;
import com.example.cinema.model.User;

public class UserDTO {

    public UserMapper chuyenUser(User user){

        UserMapper userMapper = new UserMapper();
        userMapper.setIdUser(user.getIdUser());
        userMapper.setUserName(user.getUserName());
        userMapper.setHoTen(user.getHoTen());
        userMapper.setEmail(user.getEmail());
        userMapper.setDiaChi(user.getDiaChi());
        userMapper.setSdt(user.getSdt());
        return userMapper;

    }
}
