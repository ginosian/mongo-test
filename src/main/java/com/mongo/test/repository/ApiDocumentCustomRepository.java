package com.mongo.test.repository;

import com.mongo.test.document.ApiDocument;

public interface ApiDocumentCustomRepository {

    ApiDocument customUpsert();
}
