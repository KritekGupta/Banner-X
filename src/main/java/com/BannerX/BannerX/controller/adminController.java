package com.BannerX.BannerX.controller;


import com.BannerX.BannerX.dto.LenderDTO;
import com.BannerX.BannerX.entity.Lender;
import com.BannerX.BannerX.service.LenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.BannerX.BannerX.consts.ApiConstants.*;

@RestController("/")

// needs to be removed in the future, while integrating
@CrossOrigin(origins = "*")
public class adminController {

    @Autowired
    private LenderService service;

    @PostMapping(storeLender)
    public ResponseEntity<?> createLender(@Valid @RequestBody LenderDTO dto) {
        Lender lender = service.mapDtoToEntity(dto);
        service.saveLenderData(lender);
        return ResponseEntity.ok("Lender saved successfully");
    }


    @GetMapping(lenderById)
    public Lender fetchLenderData(@PathVariable String lenderId) {
        return service.getLenderDataById(lenderId);
    }


    @GetMapping(getAll)
    public List<Lender> getAll() {
        return service.getAll();
    }
}
