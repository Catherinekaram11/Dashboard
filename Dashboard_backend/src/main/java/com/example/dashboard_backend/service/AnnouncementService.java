package com.example.dashboard_backend.service;

import com.example.dashboard_backend.DAO.AnnouncementDAO;
import com.example.dashboard_backend.entity.Announcement;
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
public class AnnouncementService {

    @Autowired
    private AnnouncementDAO announcementDAO;

    public AnnouncementService(AnnouncementDAO announcementDAO) {
        this.announcementDAO = announcementDAO;
    }

    @Transactional
    public Announcement saveAnnouncement(Announcement announcement) {
        announcementDAO.save(announcement);
        return announcement;
    }

    @Transactional
    public List<Announcement> findAllAnnouncements() {
        return announcementDAO.findAll();
    }

    @Transactional
    public Announcement updateAnnouncement(Long announcement_id, Map<String, Object> fields) {
        Announcement announcement = announcementDAO.findById(announcement_id).orElseThrow(() -> new NoSuchElementException("this announcement doesn't exist"));
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Announcement.class, key);
            field.setAccessible(true);
            try {
                ReflectionUtils.setField(field, announcement, value);
            } catch (IllegalArgumentException e) {
                ReflectionUtils.setField(field, announcement, Time.valueOf((String) value));
            }
        });
        announcementDAO.save(announcement);
        return announcement;
    }

    public void deleteAnnouncement(Long announcement_id) {
        announcementDAO.deleteById(announcement_id);
    }
}

