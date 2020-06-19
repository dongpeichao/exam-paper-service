package com.thoughtworks.paper.domain.model.paper;

import java.util.Optional;

public interface PaperRepository {
    void save(Paper paper);

    Optional<Paper> findById(String paperId);
}
