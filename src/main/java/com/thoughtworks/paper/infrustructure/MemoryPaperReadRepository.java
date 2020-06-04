package com.thoughtworks.paper.infrustructure;

import com.thoughtworks.paper.domain.model.Paper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryPaperReadRepository {
    public List<Paper> getAllByReversedOrder() {
        return null;
    }
}
