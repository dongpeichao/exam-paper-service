package com.thoughtworks.paper.adapter.repository;

import com.thoughtworks.paper.domain.model.paper.Paper;
import com.thoughtworks.paper.domain.model.paper.PaperId;
import com.thoughtworks.paper.domain.model.paper.PaperRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaperRepositoryImpl implements PaperRepository {

    private final JpaPaperRepository jpaPaperRepository;

    public PaperRepositoryImpl(JpaPaperRepository jpaPaperRepository) {
        this.jpaPaperRepository = jpaPaperRepository;
    }

    @Override
    public void save(Paper paper) {
    }

    @Override
    public Paper find(PaperId id) {
        return null;
    }
}
