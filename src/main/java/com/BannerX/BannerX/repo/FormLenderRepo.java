package com.BannerX.BannerX.repo;

import com.BannerX.BannerX.entity.Lender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormLenderRepo {

    private final MongoTemplate formMongoTemplate;

    public FormLenderRepo(@Qualifier("formMongoTemplate") MongoTemplate formMongoTemplate) {
        this.formMongoTemplate = formMongoTemplate;
    }

    public List<Lender> findAll() {
        return formMongoTemplate.findAll(Lender.class);
    }

    public boolean existsById(String lenderId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(lenderId));
        return formMongoTemplate.exists(query, Lender.class);
    }

    public void deleteById(String lenderId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(lenderId));
        formMongoTemplate.remove(query, Lender.class);
    }

    public boolean existsByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(title));
        return formMongoTemplate.exists(query, Lender.class);
    }
}
