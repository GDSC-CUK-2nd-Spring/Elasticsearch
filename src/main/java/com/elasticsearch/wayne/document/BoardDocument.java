package com.elasticsearch.wayne.document;

import com.elasticsearch.wayne.entity.Board;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;



/*
    Document는 Elasticsearch에 저장되는 데이터의 최소 단위이다.
    검색했을 때 보여야 할 데이터를 정의한다.
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
    indexName은 Elasticsearch에 저장될 인덱스의 이름을 정의한다.
    index는 Elasticsearch에 저장될 데이터의 설정을 정의한다.
    Board에 대한 정보를 바탕으로 BoardDocument를 생성한다.
 */
@Document(indexName = "boards") // document의 논리적인 집합 = index
@Setting(replicas = 0)
/*
    BoardDocument는 Elasticsearch에 저장될 데이터의 설정을 정의한다.
 */
public class BoardDocument {
    /*
        id는 Elasticsearch에 저장될 데이터의 고유 식별자이다.
        속성명이 id인 경우 Elasticsearch에서는 _id로 저장된다.
     */
    @Id
    private String id;

    private String title;

    private String content;

    //board에 대한 정보를 바탕으로 boardDocument를 생성
//    public static BoardDocument from(Board board) {
//        return BoardDocument.builder()
//                .BoardId(board.getId())
//                .title(board.getTitle())
//                .build();
//    }
}

/*
    feild는 Elasticsearch에 저장될 데이터의 필드를 정의한다.
    type은 데이터의 타입을 정의한다.
    index는 데이터의 검색 가능 여부를 정의한다.
    docValues는 데이터의 정렬 가능 여부를 정의한다.
    analyzer는 데이터의 검색 시 사용할 분석기를 정의한다.
    WriteOnlyProperty는 데이터의 저장만 가능하고 검색은 불가능하게 한다.
 */