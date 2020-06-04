package com.thoughtworks.paper.user_interface;

import com.thoughtworks.paper.domain.model.PaperId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaperDTO {
    private String uri;

    public static PaperDTO from(PaperId paperId) {
        return new PaperDTO("papers/" + paperId);
    }
}
