package com.BannerX.BannerX.dto;

import com.BannerX.BannerX.entity.LenderCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LenderDTO {
    @NotBlank(message = "Title is required")
    private String title;

//    private String imageUrl;
    private LenderCategory category;
    private boolean deployed;
    @Size(min = 1, message = "At least one screen is required")
    private List<ScreenDTO> screens;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScreenDTO {
        private String screenTitle;
        private List<FieldDTO> fields;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldDTO {
        private String name;
        private String example;
        private String type;
        private boolean required;
        private boolean validate;
        private List<String> options;

        // fields to be added which are not present in entity
//        private String placeholder; // Optional UI field
//        private String helpText;
    }
}

