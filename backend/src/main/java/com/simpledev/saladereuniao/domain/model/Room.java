package com.simpledev.saladereuniao.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "meetingroom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "startHour", nullable = false)
    private String startHour;

    @Column(name = "endHour", nullable = false)
    private String endHour;

    public Room() {
    }

    public Room(Long id, String name, String date, String startHour, String endHour) {
        Id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                '}';
    }
}
