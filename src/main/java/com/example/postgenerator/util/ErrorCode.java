package com.example.postgenerator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS("성공했습니다."),
    BAD_REQUEST("잘못된 요청입니다."),
    UNAUTHORIZED("인증에 실패했습니다."),
    FORBIDDEN("접근 권한이 없습니다."),
    NOT_FOUND("리소스를 찾을 수 없습니다."),
    POST_FAIL("블로그 글 발행에 실패했습니다."),
    GPT_GENERATION_FAIL("GPT 글 생성 실패했습니다."),
    INTERNAL_SERVER_ERROR("서버 내부 오류가 발생했습니다.");

    private final String message;
}
