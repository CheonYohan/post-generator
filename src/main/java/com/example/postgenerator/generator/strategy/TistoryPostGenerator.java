package com.example.postgenerator.generator.strategy;

import com.example.postgenerator.domain.PostRequest;
import com.example.postgenerator.domain.PostResult;
import com.example.postgenerator.generator.PostGenerator;
import org.springframework.stereotype.Service;

@Service
public class TistoryPostGenerator implements PostGenerator {

    @Override
    public PostResult generatePost(PostRequest postRequest) {
        System.out.println("Tistory에 발행합니다:");
        System.out.println("제목: " + postRequest.getTitle());
        System.out.println("내용: " + postRequest.getContent());

        // 추가 필드도 필요하면 여기서 같이 세팅
        // API 요청 본문 생성 시 tags, category, scheduledAt 활용 가능
        return null;
    }
}

