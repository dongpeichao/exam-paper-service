package com.thoughtworks.paper.adapter.repository;

import com.thoughtworks.paper.adapter.repository.entity.PaperEntity;
import com.thoughtworks.paper.domain.model.paper.Paper;
import com.thoughtworks.paper.domain.model.paper.PaperRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PaperRepositoryImpl implements PaperRepository {

    private final JpaPaperRepository jpaPaperRepository;

    public PaperRepositoryImpl(JpaPaperRepository jpaPaperRepository) {
        this.jpaPaperRepository = jpaPaperRepository;
    }

    @Override
    public void save(Paper paper) {
        jpaPaperRepository.save(PaperEntity.fromModel(paper));
    }

    @Override
    public Optional<Paper> findById(String paperId) {
        Optional<PaperEntity> paperEntity = jpaPaperRepository.findById(paperId);
        return paperEntity.map(PaperEntity::toModel);
    }
}

