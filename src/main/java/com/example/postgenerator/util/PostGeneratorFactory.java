package com.example.postgenerator.util;

import com.example.postgenerator.domain.PlatformType;
import com.example.postgenerator.generator.PostGenerator;
import com.example.postgenerator.generator.strategy.TistoryPostGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostGeneratorFactory {

    private final TistoryPostGenerator tistoryPostGenerator;

    public PostGenerator getPostGenerator(PlatformType platformType) {
        return switch (platformType) {
            case TISTORY -> tistoryPostGenerator;
            case NAVER -> null;
        };
    }
}