package com.thoughtworks.paper.application;

import com.thoughtworks.paper.domain.model.paper.IllegalQuizzesCountException;
import com.thoughtworks.paper.domain.model.paper.Paper;
import com.thoughtworks.paper.domain.model.paper.PaperId;
import com.thoughtworks.paper.domain.model.paper.PaperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaperApplicationService {
    private final PaperRepository paperRepository;

    public PaperApplicationService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public PaperId assemblePaper(AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        List<Paper.BlankQuiz> blankQuizzes = blankQuizFrom(command);
        String teacherId = command.getTeacherId();
        Paper paper = Paper.assemble(blankQuizzes, teacherId);
        paperRepository.save(paper);
        return paper.getId();
    }

    private List<Paper.BlankQuiz> blankQuizFrom(AssemblePaperCommand command) {
        return command.getQuizzes().stream()
                .map(quiz -> new Paper.BlankQuiz(quiz.getQuizId(), quiz.getScore()))
                .collect(Collectors.toList());
    }
}
