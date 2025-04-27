package com.example.postgenerator.controller;

import com.example.postgenerator.client.GptClient;
import com.example.postgenerator.domain.*;
import com.example.postgenerator.generator.PostGenerator;
import com.example.postgenerator.util.ErrorCode;
import com.example.postgenerator.util.PostGeneratorFactory;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PogenApiController {

    private final PostGeneratorFactory postGeneratorFactory;

    @PostMapping("/auto-post")
    public ResponseEntity<ApiResponse<PostResult>> autoPost(
            @RequestParam PlatformType platformType,
            @Valid @RequestBody PostRequest postRequest) {

        PostGenerator generator = postGeneratorFactory.getPostGenerator(platformType);
        PostResult result = generator.generatePost(postRequest);

        if (result.getStatus() == PostStatus.SUCCESS) {
            return ResponseEntity.ok(
                    ApiResponse.<PostResult>builder()
                            .success(true)
                            .code(ErrorCode.SUCCESS.name())
                            .message(ErrorCode.SUCCESS.getMessage())
                            .data(result)
                            .build()
            );
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.<PostResult>builder()
                            .success(false)
                            .code(ErrorCode.POST_FAIL.name())
                            .message(result.getMessage())
                            .data(null)
                            .build()
                    );
        }
    }
}
