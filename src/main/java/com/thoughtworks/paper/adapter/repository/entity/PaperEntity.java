package com.thoughtworks.paper.adapter.repository.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.paper.domain.model.paper.Paper;
import com.thoughtworks.paper.domain.model.paper.PaperId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "t_paper")
public class PaperEntity {
    @Id
    private String id;

    private String blankQuizzes;

    private String teacherId;

    public Paper toModel() {
        return Paper.builder()
                .teacherId(teacherId)
                .id(new PaperId(id))
                .blankQuizzes(new ObjectMapper().convertValue(blankQuizzes, List.class))
                .build();
    }


    public static PaperEntity fromModel(Paper paper) {
        PaperEntity result = new PaperEntity();
        result.id = paper.getId().toString();
        try {
            result.blankQuizzes = new ObjectMapper().writeValueAsString(paper.getBlankQuizzes());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        result.teacherId = paper.getTeacherId();
        return result;
    }
}
