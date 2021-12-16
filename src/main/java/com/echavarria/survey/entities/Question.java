package com.echavarria.survey.entities;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONS")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Column(name = "ANSWER")
    private String answer;

    public Question() {
    }

    public Question(Long id, String description, QuestionType type, String answer) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
