package com.thoughtworks.paper.domain.model;

public class IllegalScoreException extends IllegalArgumentException {
    public IllegalScoreException(int score) {
        super("IllegalScoreException: exception score less than 100, actual:" + score);
    }
}
