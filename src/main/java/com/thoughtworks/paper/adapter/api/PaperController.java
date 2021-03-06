package com.thoughtworks.paper.adapter.api;

import com.thoughtworks.paper.application.AssemblePaperCommand;
import com.thoughtworks.paper.application.PaperApplicationService;
import com.thoughtworks.paper.application.QueryPaperDTO;
import com.thoughtworks.paper.domain.model.paper.IllegalQuizzesCountException;
import com.thoughtworks.paper.domain.model.paper.PaperId;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/papers")
public class PaperController {
    private PaperApplicationService paperApplicationService;

    public PaperController(PaperApplicationService paperApplicationService) {
        this.paperApplicationService = paperApplicationService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PaperDTO assemble(@RequestBody AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        PaperId paperId = paperApplicationService.assemblePaper(command);
        return PaperDTO.from(paperId.toString());
    }

    @GetMapping(value = "/{paperId}")
    @ResponseStatus(HttpStatus.OK)
    public QueryPaperDTO query(@PathVariable("paperId") String paperId) {
        return paperApplicationService.query(paperId);
    }
}
