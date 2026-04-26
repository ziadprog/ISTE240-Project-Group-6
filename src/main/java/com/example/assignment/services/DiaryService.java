package com.example.assignment.services;
//Shahid Rizwan-415004364
import com.example.assignment.model.Diary;
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

    public List<Diary> getByUserId(Long userId) {
        return diaryRepository.findByUserId(userId);
    }

    public List<Diary> findByUserAndTitle(Long userId, String title) {
        return diaryRepository.findByUserAndTitle(userId, title);
    }

    public Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    public void updateDiary(Long id, Diary diary) {
        diaryRepository.updateDiaryById(
                id,
                diary.getTitle(),
                diary.getContent(),
                diary.getDate(),
                diary.getUser()
        );
    }
}