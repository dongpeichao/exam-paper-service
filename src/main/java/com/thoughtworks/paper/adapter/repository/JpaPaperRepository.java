package com.thoughtworks.paper.adapter.repository;

import com.thoughtworks.paper.adapter.repository.entity.PaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaperRepository extends JpaRepository<PaperEntity, String> {

}
