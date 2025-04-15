package com.BannerX.BannerX.Controller;


import com.BannerX.BannerX.Consts.Consts;
import com.BannerX.BannerX.Model.Lender;
import com.BannerX.BannerX.Service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.BannerX.BannerX.Consts.Consts.baseUrl;
import static com.BannerX.BannerX.Consts.Consts.lenderById;

@RestController("")
@CrossOrigin(origins = "http://localhost:5174")
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
