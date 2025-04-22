package com.BannerX.BannerX.controller;


import com.BannerX.BannerX.model.Lender;
import com.BannerX.BannerX.service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.BannerX.BannerX.consts.Consts.baseUrl;
import static com.BannerX.BannerX.consts.Consts.lenderById;

@RestController("")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private Lender lender;
    @Autowired
    private LenderService service;


//    @PostMapping(baseUrl)
    @PostMapping(baseUrl)
    public void storingLenderData(@RequestBody Lender lender) {
        service.saveLenderData(lender);
    }

    @GetMapping(lenderById)
    public Lender fetchLenderData(@PathVariable String lenderId) {
        return service.getLenderDataById(lenderId);
    }
}
