package com.example.board.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IdResponse<T> {
    T id;
}
