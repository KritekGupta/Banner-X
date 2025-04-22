package com.BannerX.BannerX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Lender {

    @Id
    private String id;

    private String title;
    private List<Screens> screens;
}
