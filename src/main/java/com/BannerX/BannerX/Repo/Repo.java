package com.BannerX.BannerX.Repo;

import com.BannerX.BannerX.Model.Lender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repo extends MongoRepository<Lender, String> {
}
