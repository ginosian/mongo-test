package com.mongo.test.repository.impl;

import com.mongo.test.document.ApiDocument;
import com.mongo.test.listener.ApplicationListener;
import com.mongo.test.repository.ApiDocumentCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class ApiDocumentCustomRepositoryImpl implements ApiDocumentCustomRepository {

    private static final FindAndModifyOptions UPSERT = FindAndModifyOptions.options().upsert(true);

    private static final String COLLECTION_NAME = "apidocument";

    private final MongoTemplate mongoTemplate;

    private final MongoTemplate secondaryReadTemplate;


    @Autowired
    public ApiDocumentCustomRepositoryImpl(MongoTemplate mongoTemplate, MongoTemplate secondaryReadTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.secondaryReadTemplate = secondaryReadTemplate;
    }

    public ApiDocument customUpsert() {

        Query query = new Query(Criteria.where("id").is(ApplicationListener.id));

        final Update update = new Update();
        update.setOnInsert("positions", "three");

        final ApiDocument result = mongoTemplate.findAndModify(query, update, UPSERT, ApiDocument.class);

        return result;

    }

}
