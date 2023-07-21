package com.springboot.todolist_application_springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//   todolist is the paretn so we want to mapped it with the child using the co;umn name in that table.
    //orphane removal mean when we delete the parent in any case we have to delete the prphans of ot tooo.
    @OneToMany(mappedBy = "todoList" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Task> tasks = new ArrayList<Task>();

}
