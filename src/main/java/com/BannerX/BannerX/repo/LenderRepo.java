package com.BannerX.BannerX.repo;

import com.BannerX.BannerX.entity.Lender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repo extends MongoRepository<Lender, String> {
}
