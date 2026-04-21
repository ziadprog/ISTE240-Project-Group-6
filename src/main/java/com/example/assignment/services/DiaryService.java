package com.example.assignment.services;

import com.example.assignment.model.Diary;
import com.example.assignment.model.User;
import com.example.assignment.repositories.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }

    public Optional<Diary> getDiaryById(Long id) {
        return diaryRepository.findById(id);
    }

    public List<Diary> getByTitle(String title) {
        return diaryRepository.findByTitle(title);
    }

    public List<Diary> getByUser(User user) {
        return diaryRepository.findByUser(user);
    }

    public List<Diary> searchByTitle(String title) {
        return diaryRepository.searchByTitle(title);
    }

    public Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    public int updateContent(Long id, String content) {
        return diaryRepository.updateContentById(id, content);
    }
}
