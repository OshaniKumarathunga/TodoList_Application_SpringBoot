package com.springboot.todolist_application_springboot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private Date startDate;
    private Date dueDate;
    private boolean done;
    private boolean favorite;

    //many patte thmai Id ek save kragane,wenam column ekaka ek nisa Join column eken Id ek gannawa
    //Fetch type lazy eke Id relationship ek withrai load wenne  , Whole object ek load wene na.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todolist_id")
    private TodoList todoList;

}
