package com.thoughtworks.paper.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaperDetailDTO {
    private String id;
    public static PaperDetailDTO from() {
        return null;
    }
}
