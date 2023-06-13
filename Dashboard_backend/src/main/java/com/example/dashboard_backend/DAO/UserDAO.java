package com.example.dashboard_backend.DAO;


import com.example.dashboard_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User ,Long> {

}
