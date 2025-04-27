package com.example.postgenerator.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResult {
    private PostStatus status;
    private String body;
    private String message;
    private String errorCode;
}
