package com.thoughtworks.paper.adapter.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
}
