package com.example.postgenerator.generator;

import com.example.postgenerator.domain.PostRequest;
import com.example.postgenerator.domain.PostResult;

public interface PostGenerator {
    PostResult generatePost(PostRequest postRequest);
}
