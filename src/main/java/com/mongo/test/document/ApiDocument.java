package com.mongo.test.document;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@Document(collection = "apidocument")
public class ApiDocument {

    @Field("api_id")
    private String id;

    @Field("countries")
    private Set<String> countries;

    @Field("positions")
    private Set<ApiPositionDocument> positions;

}
