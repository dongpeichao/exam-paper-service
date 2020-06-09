package com.thoughtworks.paper.domain.model.paper;

public interface PaperRepository {
    void save(Paper paper);

    Paper find(PaperId id);
}
