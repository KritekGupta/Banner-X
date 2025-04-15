package com.BannerX.BannerX.Model;

import com.BannerX.BannerX.Service.LenderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Lender {

    @Id
    private String id;

    private String lenderName;
    private List<ScreenFeatures> screens;
}
