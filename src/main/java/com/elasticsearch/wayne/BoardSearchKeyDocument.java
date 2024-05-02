package com.elasticsearch.wayne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@NoArgsConstructor
/*
    BoardSearchKeyDocument는 검색 키워드를 저장하는 객체이다.
 */
public class BoardSearchKeyDocument {
    @Field(type = FieldType.Keyword, index = false, docValues = false)
    private String key;

    public BoardSearchKeyDocument(String key) {
        this.key = key;
    }
}