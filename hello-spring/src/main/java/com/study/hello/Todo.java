package com.study.hello;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean done;

    // 새로 추가: 여러 Todo가 하나의 Category에 속함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Todo() {}

    public Todo(String title, boolean done, Category category) {
        this.title = title;
        this.done = done;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) { this.title = title; }
    public void setDone(boolean done) { this.done = done; }
    public void setCategory(Category category) { this.category = category; }
}