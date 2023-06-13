package com.example.dashboard_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long quiz_id;

    @Column
    private String title;

    @Column
    private String course;

    @Column
    private String topic;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_time;

//
//    public Quiz(String title, String course, String topic, LocalDateTime date_time) {
//        this.title = title;
//        this.course = course;
//        this.topic = topic;
//        this.date_time = date_time;
//    }

}
