package com.BannerX.BannerX.Service;


import com.BannerX.BannerX.Model.Lender;
import com.BannerX.BannerX.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LenderService {

    @Autowired
    private Repo repo;

    @Autowired
    private Lender lender;

    public void saveLenderData(Lender lender) {
        repo.save(lender);
    }

    public Lender getLenderDataById(String id) {
        return repo.findById(id).orElse(null);
    }


}
