package com.thoughtworks.paper.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class AssemblePaperCommand {
    private String teacherId;
    private List<Quiz> quizzes;

    @Value
    public static class Quiz {
        private String quizId;
        private int score;
    }
}