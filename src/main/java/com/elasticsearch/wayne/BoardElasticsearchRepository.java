package com.elasticsearch.wayne;

import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

// 우선 title만 검색해보자
public interface BoardElasticsearchRepository extends ElasticsearchRepository<BoardDocument, String> {
    /*
        SearchHits는 Elasticsearch에서 검색된 결과를 담는 객체
        총 결과 개수, 검색 결과 리스트, 페이징 정보 등을 담고 있다.
     */
//    SearchHits<BoardDocument> findByTitle(String title);
}