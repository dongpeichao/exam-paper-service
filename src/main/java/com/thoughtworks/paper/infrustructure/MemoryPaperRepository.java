package com.thoughtworks.paper.infrustructure;

import com.thoughtworks.paper.domain.model.Paper;
import com.thoughtworks.paper.domain.model.PaperId;
import com.thoughtworks.paper.domain.model.PaperRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryPaperRepository implements PaperRepository {
    private Set<Paper> papers = new HashSet<>();

    @Override
    public Paper find(PaperId paperId) {
        return papers.stream().filter(paper -> paper.getPaperId().equals(paperId))
                .findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Paper paper) {
        papers.add(paper);
    }

    @Override
    public PaperId nextPaperId() {
        return new PaperId("paper-" + UUID.randomUUID().toString());
    }

    @Override
    public List<Paper> getAll() {
        return papers.stream().collect(Collectors.toList());
    }
}
