package com.elasticsearch.wayne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}


//{
//    "_class" : "com.elasticsearch.wayne.entity.Board",
//    "id" : "cb7bef",
//    "title" : "Elasticsearch"
//}