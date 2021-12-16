package com.echavarria.survey.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SURVEYS")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SURVEY_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SURVEY_QUESTION")
    private List<Question> questions;

    public Survey() {
    }

    public Survey(Long id, String username, String emailAddress, String topic, List<Question> questions) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.topic = topic;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", topic='" + topic + '\'' +
                ", questions=" + questions +
                '}';
    }
}
