package com.thoughtworks.paper.domain.model.paper;

import com.thoughtworks.paper.common.ddd.annotation.AggregateRoot;
import com.thoughtworks.paper.common.ddd.annotation.ValueObject;
import lombok.*;

import java.util.List;

@SuppressWarnings("checkstyle:magicnumber")
@AggregateRoot
@Data
//@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@Builder
@EqualsAndHashCode(of = "id")
public class Paper {
    private PaperId id;
    private List<BlankQuiz> blankQuizzes;
    private String teacherId;

    public static Paper assemble(final List<BlankQuiz> blankQuizzes,
                                 final String teacherId) throws IllegalQuizzesCountException {
        validateQuizzes(blankQuizzes);
        return Paper.builder()
                .id(PaperId.generate())
                .blankQuizzes(blankQuizzes)
                .teacherId(teacherId)
                .build();
    }
    private static void validateQuizzes(final List<BlankQuiz> blankQuizzes) throws IllegalQuizzesCountException {
        if (blankQuizzes.size() > 20 || blankQuizzes.size() < 5) {
            throw new IllegalQuizzesCountException(blankQuizzes.size());
        }
    }

    @ValueObject
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BlankQuiz {
        private String id;
        private Integer score;
    }
}
