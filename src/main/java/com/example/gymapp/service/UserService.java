package com.example.gymapp.service;

import com.example.gymapp.entity.User;
import com.example.gymapp.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HashMap<String, Object> registerUser(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if ( userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt()) ) {
            // user already registered
            map.put("message", "User already registered with same email or mobile");
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
            map.put("isAlreadyRegistered", true);
            map.put("body", null);
        } else {
            // user not registered
            User newUser = userRepository.save(user);
            map.put("message", "User Registered Successfully");
            map.put("status", HttpStatus.OK.toString());
            map.put("isAlreadyRegistered", false);
            map.put("body", newUser);
        }

        return map;
    }

    public HashMap<String, Object> loginUser(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if (userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt())) {

            if (userRepository.existsByMobile_txtLikeAndPassword(
                    user.getMobile_txt(), user.getPassword())) {

                user = userRepository.findByMobile_txtLikeIgnoreCase(user.getMobile_txt());

                map.put("message", "Login Successful!");
                map.put("body", user);
                map.put("status", HttpStatus.OK.toString());
            } else {
                map.put("message", "Incorrect Password");
                map.put("body", null);
                map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
            }
        } else {
            map.put("message", "User not exists!");
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        }

        if (user.getIdPk_int() != 0) map.put("body", user);

        return map;
    }

    public HashMap<String, Object> changePassword(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if (userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt())) {

            String newPassword = user.getPassword();
            user = userRepository.findByMobile_txtLikeIgnoreCase(user.getMobile_txt());

            // replace password
            user.setPassword(newPassword);
            user = userRepository.save(user);

            map.put("message", "Password change successful!");
            map.put("body", user);
            map.put("status", String.valueOf(HttpStatus.OK));
        } else {
            map.put("message", "User not exists!");
            map.put("body", null);
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        }

        if (user.getIdPk_int() != 0) map.put("body", user);

        return map;
    }

    public HashMap<String, Object> updateUser(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if (userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt())) {

            user = userRepository.save(user);

            map.put("message", "Update Successful!");
            map.put("status", String.valueOf(HttpStatus.OK));
        } else {
            map.put("message", "User not exists!");
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        }

        if (user.getIdPk_int() != 0) map.put("body", user);

        return map;
    }

    public HashMap<String, Object> getUser(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if (userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt())) {

            user = userRepository.findByMobile_txtLikeIgnoreCase(user.getMobile_txt());

            map.put("message", "1 User Found");
            map.put("status", String.valueOf(HttpStatus.OK));
        } else {
            map.put("message", "User not exists!");
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        }

        if (user.getIdPk_int() != 0) map.put("body", user);

        return map;
    }

    public HashMap<String, Object> getAllUser(User user) {

        HashMap<String, Object> map = new HashMap<>();

        if (userRepository.checkIfUserExists(
                user.getMobile_txt(), user.getEmail_txt())) {

            user = userRepository.findByMobile_txtLikeIgnoreCase(user.getMobile_txt());

            map.put("message", "1 User Found");
            map.put("status", String.valueOf(HttpStatus.OK));
        } else {
            map.put("message", "User not exists!");
            map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        }

        if (user.getIdPk_int() != 0) map.put("body", user);

        return map;
    }

}