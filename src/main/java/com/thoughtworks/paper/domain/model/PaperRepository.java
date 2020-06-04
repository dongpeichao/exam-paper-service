package com.thoughtworks.paper.domain.model;

import java.util.List;

public interface PaperRepository {
    Paper find(PaperId paperId);

    void save(Paper paper);

    PaperId nextPaperId();

    List<Paper> getAll();
}
