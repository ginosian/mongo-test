package com.mongo.test.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
public class ApiPositionDocument {

    @Field("position")
    private String position;

    @Field("date")
    private String date;
}
