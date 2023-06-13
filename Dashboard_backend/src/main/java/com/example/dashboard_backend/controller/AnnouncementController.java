package com.example.dashboard_backend.controller;

import com.example.dashboard_backend.entity.Announcement;
import com.example.dashboard_backend.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveAnnouncement(@RequestBody Announcement announcement) {
        try {
            announcementService.saveAnnouncement(announcement);
            return ResponseEntity.ok("Announcement saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save announcement!");
        }
    }

    @GetMapping("/getAll")
    public List<Announcement> findAllAnnouncements() {
        return announcementService.findAllAnnouncements();
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateAnnouncement(@RequestParam Long announcement_id, @RequestBody Map<String, Object> fields) {
        try {
            Announcement announcement = announcementService.updateAnnouncement(announcement_id, fields);
            return ResponseEntity.ok("Announcement updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update Announcement!");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteAnnouncement(@RequestParam Long announcement_id) {
        try {
            announcementService.deleteAnnouncement(announcement_id);
            return ResponseEntity.ok("Announcement deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete Announcement!");
        }
    }
}
