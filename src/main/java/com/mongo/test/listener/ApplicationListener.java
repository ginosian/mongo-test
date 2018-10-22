package com.mongo.test.listener;

import com.google.common.collect.Sets;
import com.mongo.test.document.ApiDocument;
import com.mongo.test.document.ApiPositionDocument;
import com.mongo.test.repository.ApiDocumentCustomRepository;
import com.mongo.test.repository.ApiDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListener {

    public static String id = "";

    private ApiDocumentRepository apiDocumentRepository;


    private ApiDocumentCustomRepository apiDocumentCustomRepository;


    @Autowired
    public ApplicationListener(ApiDocumentRepository apiDocumentRepository, ApiDocumentCustomRepository apiDocumentCustomRepository) {
        this.apiDocumentRepository = apiDocumentRepository;
        this.apiDocumentCustomRepository = apiDocumentCustomRepository;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() {
        final ApiDocument apiDocument = apiDocumentRepository.save(created());
        id = apiDocument.getId();
        final ApiDocument upserted = apiDocumentCustomRepository.customUpsert();
        System.out.println();

    }

    public static ApiDocument created(){
        final ApiDocument apiDocument = new ApiDocument();
        apiDocument.setCountries(Sets.newHashSet("AM", "DE"));
        final ApiPositionDocument positionDocument1 = new ApiPositionDocument();
        positionDocument1.setPosition("one");
        positionDocument1.setDate("some date1");
        final ApiPositionDocument positionDocument2 = new ApiPositionDocument();
        positionDocument2.setPosition("two");
        positionDocument2.setDate("some date2");
        final ApiPositionDocument positionDocument3 = new ApiPositionDocument();
        positionDocument3.setPosition("three");
        positionDocument3.setDate("some date3");
        apiDocument.setPositions(Sets.newHashSet(positionDocument1, positionDocument2, positionDocument3));
        return apiDocument;
    }
}
