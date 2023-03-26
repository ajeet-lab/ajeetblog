package com.ajeet.blog.ajeetblog.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajeet.blog.ajeetblog.entites.User;
import com.ajeet.blog.ajeetblog.payloads.UserDto;
import com.ajeet.blog.ajeetblog.repos.UserRepo;
import com.ajeet.blog.ajeetblog.services.UserService;
import com.ajeet.blog.ajeetblog.exceptions.*;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.DtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return this.UserToDto(savedUser);
    }

    @Override
    public UserDto updateUserById(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId.toString()));

        user.setName(userDto.getName());
        User updatedUser = this.userRepo.save(user);
        return UserToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId.toString()));
        return UserToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id", userId.toString()));     
        this.userRepo.delete(user);
    }
    

    private User DtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMobile(userDto.getMobile());
        return user;
    }

    private UserDto UserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setMobile(user.getMobile());
        return userDto;
    }
}
