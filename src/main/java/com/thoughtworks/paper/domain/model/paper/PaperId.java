package com.thoughtworks.paper.domain.model.paper;

import com.thoughtworks.paper.common.ddd.annotation.ValueObject;
import com.thoughtworks.paper.common.ddd.core.AbstractId;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@ValueObject
@EqualsAndHashCode(callSuper = true)
public
class PaperId extends AbstractId {
    public PaperId(final String value) {
        super(value);
    }

    public static PaperId generate() {
        return new PaperId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
