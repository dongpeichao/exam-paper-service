package com.thoughtworks.paper.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
