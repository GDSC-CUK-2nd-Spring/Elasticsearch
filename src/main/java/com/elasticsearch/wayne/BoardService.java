package com.elasticsearch.wayne;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardElasticsearchRepository boardElasticsearchRepository;
    private final BoardRepository boardRepository;


    /*
        글 작성, 수정, 삭제
     */
}
