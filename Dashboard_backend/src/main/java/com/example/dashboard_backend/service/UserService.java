package com.example.dashboard_backend.service;

import com.example.dashboard_backend.DAO.UserDAO;
import com.example.dashboard_backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User saveUser(User user) {
        userDAO.save(user);
        return user;
    }

    @Transactional
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public User updateUser(Long user_id, Map<String, Object> fields) {
        User user = userDAO.findById(user_id).orElseThrow(() -> new NoSuchElementException("this user doesn't exist"));
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, key);
            field.setAccessible(true);
            try {
                ReflectionUtils.setField(field, user, value);
            } catch (IllegalArgumentException e) {
                ReflectionUtils.setField(field, user, Time.valueOf((String) value));
            }
        });
        userDAO.save(user);
        return user;
    }

    @Transactional
    public void deleteUserById(Long user_id) {
        userDAO.deleteById(user_id);

    }

}
