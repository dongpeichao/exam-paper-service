package com.thoughtworks.paper.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class PaperDTO {
    private String paperId;

    public static PaperDTO from(final String paperId) {
        return new PaperDTO(paperId);
    }
}
