package org.sopt.server.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.server.dto.response.QuestionsResponse;
import org.sopt.server.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionsResponse> getQuestionList() {
        return QuestionsResponse.listOf(questionRepository.findFirstQuestionsEachDay());
    }
}
