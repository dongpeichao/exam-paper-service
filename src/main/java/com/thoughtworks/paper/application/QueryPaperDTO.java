package com.thoughtworks.paper.application;

import com.thoughtworks.paper.domain.model.paper.Paper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class QueryPaperDTO {
    private String paperId;
    private String teacherId;
    private List<Paper.BlankQuiz> quizzes;

}