package com.elasticsearch.wayne.repository;

import com.elasticsearch.wayne.document.BoardDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BoardElasticsearchRepository extends ElasticsearchRepository<BoardDocument, String> {
    List<BoardDocument> findByTitleContains(String title);
}