package com.thoughtworks.paper.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
