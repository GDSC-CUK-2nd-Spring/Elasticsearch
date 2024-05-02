package com.elasticsearch.wayne;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.ArrayList;
import java.util.List;

/*
    Document는 Elasticsearch에 저장되는 데이터의 최소 단위이다.
    검색했을 때 보여야 할 데이터를 정의한다.
 */

@Getter
@Setter
/*
    indexName은 Elasticsearch에 저장될 인덱스의 이름을 정의한다.
    index는 Elasticsearch에 저장될 데이터의 설정을 정의한다.
    Board에 대한 정보를 바탕으로 BoardDocument를 생성한다.
 */
@Document(indexName = "boards")
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

    @Field(type = FieldType.Long, index = false, docValues = false)
    private Long BoardId;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String title;

    @Field(type = FieldType.Object)
    private List<TagDocument> tags = new ArrayList<>();

    @Field(type = FieldType.Object)
    @WriteOnlyProperty
    private List<BoardSearchKeyDocument> searchKeys = new ArrayList<>();
}

/*
    feild는 Elasticsearch에 저장될 데이터의 필드를 정의한다.
    type은 데이터의 타입을 정의한다.
    index는 데이터의 검색 가능 여부를 정의한다.
    docValues는 데이터의 정렬 가능 여부를 정의한다.
    analyzer는 데이터의 검색 시 사용할 분석기를 정의한다.
    WriteOnlyProperty는 데이터의 저장만 가능하고 검색은 불가능하게 한다.
 */