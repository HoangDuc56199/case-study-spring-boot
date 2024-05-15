package com.example.demo.service.impl;

import com.example.demo.entity.QuestionType;
import com.example.demo.repository.IQuestionTypeRepository;
import com.example.demo.service.IQuestionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class QuestTypeService implements IQuestionTypeService {
    private final IQuestionTypeRepository questionTypeRepository;
    @Override
    public QuestionType findById(UUID id) {
        return questionTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void deleteById(UUID id) {

    }
}
