package com.elasticsearch.wayne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "board_search_keys")
/*
    BoardSearchKey는 게시판의 검색 키워드를 저장하는 엔티티입니다.
 */
public class BoardSearchKey {
    @Id
    private Long id;

    @Column(name = "search_key")
    private String key;
}
