package com.BannerX.BannerX.repo;

import com.BannerX.BannerX.entity.Lender;
import com.BannerX.BannerX.entity.LenderCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LenderRepo extends MongoRepository<Lender, String> {
    boolean existsByTitle(String title);
    List<Lender> findByCategory(LenderCategory category);
}

