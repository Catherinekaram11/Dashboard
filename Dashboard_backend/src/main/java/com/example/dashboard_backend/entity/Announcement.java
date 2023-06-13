package com.example.dashboard_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long announcement_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column
    private String title;

    @Column
    private String content;


//    public Announcement(User user, String title, String content) {
//        this.user = user;
//        this.title = title;
//        this.content = content;
//    }

}
