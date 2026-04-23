package com.example.assignment.controllers;

import com.example.assignment.model.Diary;
import com.example.assignment.services.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/api/diary")
    public List<Diary> getAllDiaries() {
        return diaryService.getAllDiaries();
    }

    @GetMapping("/api/diary/{id}")
    public ResponseEntity<Diary> getDiaryById(@PathVariable Long id) {
        Diary diary = diaryService.getDiaryById(id).orElse(null);

        if (diary == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(diary);
    }

    @GetMapping("/api/diary/search")
    public List<Diary> searchDiaries(@RequestParam String title) {
        return diaryService.searchByTitle(title);
    }

    @GetMapping("/api/diary/user/{userId}")
    public List<Diary> getDiariesByUser(@PathVariable Long userId) {
        return diaryService.getByUserId(userId);
    }

    @GetMapping("/api/diary/user/{userId}/search")
    public List<Diary> searchUserDiaries(@PathVariable Long userId, @RequestParam String title) {
        return diaryService.searchByUserAndTitle(userId, title);
    }

    @PostMapping("/api/diary")
    public ResponseEntity<Diary> createDiary(@RequestBody Diary diary) {
        return ResponseEntity.ok(diaryService.saveDiary(diary));
    }

    @PutMapping("/api/diary/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable Long id, @RequestBody Diary updatedDiary) {
        Diary existingDiary = diaryService.getDiaryById(id).orElse(null);

        if (existingDiary == null) {
            return ResponseEntity.notFound().build();
        }

        existingDiary.setTitle(updatedDiary.getTitle());
        existingDiary.setContent(updatedDiary.getContent());
        existingDiary.setDate(updatedDiary.getDate());
        existingDiary.setUserId(updatedDiary.getUserId());

        return ResponseEntity.ok(diaryService.saveDiary(existingDiary));
    }

    @DeleteMapping("/api/diary/{id}")
    public ResponseEntity<String> deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok("Diary deleted successfully");
    }
}
