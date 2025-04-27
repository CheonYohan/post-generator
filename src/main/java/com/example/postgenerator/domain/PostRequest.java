package com.example.postgenerator.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "본문 내용은 필수입니다.")
    private String content;

    private List<String> tags;
    private String category;
    private String thumbnailUrl;
    private LocalDateTime scheduledAt;
}
