package com.example.board.articleV2.exception;

public class LikeCountMinusException extends IllegalStateException{
    private static final String MESSAGE = "좋아요는 마이너스가 될 수 없습니다.";

    public LikeCountMinusException() {
        super(MESSAGE);
    }
}
