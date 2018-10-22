package com.mongo.test.repository;

import com.mongo.test.document.ApiDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiDocumentRepository extends MongoRepository<ApiDocument, String> {
}
