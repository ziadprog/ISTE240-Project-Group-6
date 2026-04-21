package com.example.assignment.controllers;

import com.example.assignment.model.Diary;
import com.example.assignment.services.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin(origins = "*")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public List<Diary> getAllDiaries() {
        return diaryService.getAllDiaries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiaryById(@PathVariable Long id) {
        return diaryService.getDiaryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Diary> searchDiaries(@RequestParam String title) {
        return diaryService.searchByTitle(title);
    }

    @PostMapping
    public ResponseEntity<Diary> createDiary(@RequestBody Diary diary) {
        return ResponseEntity.ok(diaryService.saveDiary(diary));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable Long id, @RequestBody Diary updatedDiary) {
        return diaryService.getDiaryById(id)
                .map(existing -> {
                    existing.setTitle(updatedDiary.getTitle());
                    existing.setContent(updatedDiary.getContent());
                    existing.setDate(updatedDiary.getDate());
                    existing.setUser(updatedDiary.getUser());
                    return ResponseEntity.ok(diaryService.saveDiary(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok("Diary deleted successfully");
    }
}
