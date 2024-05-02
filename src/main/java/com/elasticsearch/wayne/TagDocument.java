package com.elasticsearch.wayne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@NoArgsConstructor
/*
    TagDocument는 Elasticsearch에 저장될 태그 설정을 정의한다.
 */
public class TagDocument {
    @Field(type = FieldType.Keyword, index = false, docValues = false)
    private String title;

    public TagDocument(String title) {
        this.title = title;
    }
}