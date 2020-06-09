package com.thoughtworks.paper.adapter.api;

import com.thoughtworks.paper.application.AssemblePaperCommand;
import com.thoughtworks.paper.application.PaperApplicationService;
import com.thoughtworks.paper.domain.model.paper.IllegalQuizzesCountException;
import com.thoughtworks.paper.domain.model.paper.PaperId;
import org.springframework.http.HttpStatus;
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
    public PaperDTO assemble(@RequestBody final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        PaperId paperId = paperApplicationService.assemblePaper(command);
        return PaperDTO.from(paperId.toString());
    }

    @PutMapping("/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PaperDTO reassemble(@PathVariable final String paperId,
                               @RequestBody final AssemblePaperCommand command)
            throws IllegalQuizzesCountException {
        PaperId newPaperId = paperApplicationService.reassemblePaper(paperId, command);
        return PaperDTO.from(newPaperId.toString());
    }
}
