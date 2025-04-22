package com.BannerX.BannerX.service;


import com.BannerX.BannerX.dto.LenderDTO;
import com.BannerX.BannerX.entity.Lender;
import com.BannerX.BannerX.repo.LenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenderService {

    @Autowired
    private LenderRepo lenderRepo;


    public Lender mapDtoToEntity(LenderDTO dto) {
        List<Lender.Screens> screens = dto.getScreens().stream().map(screenDTO -> {
            List<Lender.Screens.Field> fields = screenDTO.getFields().stream().map(fieldDTO ->
                    new Lender.Screens.Field(
                            fieldDTO.getName(),
                            fieldDTO.getExample(),
                            fieldDTO.getType(),
                            fieldDTO.isRequired(),
                            fieldDTO.getOptions()
                    )
            ).toList();

            return new Lender.Screens(screenDTO.getScreenTitle(), fields);
        }).toList();

        return new Lender(null, dto.getTitle(), screens, null, null); // createdAt/updatedAt handled by Spring
    }
    public void saveLenderData(Lender lender) {
        lenderRepo.save(lender);
    }

    public Lender getLenderDataById(String id) {
        return lenderRepo.findById(id).orElse(null);
    }

    public List<Lender> getAll() { return lenderRepo.findAll(); }
}
