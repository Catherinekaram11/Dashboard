package com.example.dashboard_backend.DAO;

import com.example.dashboard_backend.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDAO extends JpaRepository<Announcement, Long> {
}
