package com.example.assignment.services;

import com.example.assignment.model.Diary;
import com.example.assignment.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDiaryService {
    //Lists
    private List<User> users = new ArrayList<User>();
    private List<Diary> diaries = new ArrayList<Diary>();

    //GET lists
    public List<User> findAllUsers() {return users;}
    public List<Diary> findAllDiaries() {return diaries;}

    //POST entities (add)
    public void addUser(User user) {
            this.users.add(user);
    }

    public void addDiary (Diary diary){
        diaries.add(diary);
    }

    //to have preset table data and show user and diary link
    @PostConstruct
    public void init() {
        User user = new User("1", "Ali", "ali@gmail.com");
        Diary diary = new Diary("My Day", "It was good", "2026-03-14", user);

        users.add(user);
        diaries.add(diary);
    }
}
