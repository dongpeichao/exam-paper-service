package com.thoughtworks.paper.user_interface;

import com.thoughtworks.paper.application.AssemblePaperCommand;
import com.thoughtworks.paper.application.PaperService;
import com.thoughtworks.paper.domain.model.Paper;
import com.thoughtworks.paper.domain.model.PaperId;
import com.thoughtworks.paper.infrustructure.MemoryPaperReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    private PaperService paperService;
    private MemoryPaperReadRepository paperReadRepository;

    @Autowired
    public PaperController(PaperService paperService, MemoryPaperReadRepository paperReadRepository) {
        this.paperService = paperService;
        this.paperReadRepository = paperReadRepository;
    }

    @PostMapping("/papers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    PaperDTO assemble(@RequestBody AssemblePaperCommand command) {
        PaperId paperId = paperService.assemblePaper(command);
        return PaperDTO.from(paperId);
    }

    @GetMapping("/papers")
        //读请求,获取倒序排列的Paper
    List<Paper> getAll() {
        return paperReadRepository.getAllByReversedOrder();
    }

    @PutMapping("/papers/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void reassemble(@PathVariable String paperId, @RequestBody AssemblePaperCommand command) {
        paperService.reassemblePaper(paperId, command);
    }
}
