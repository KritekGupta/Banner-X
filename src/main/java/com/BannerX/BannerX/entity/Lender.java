package com.BannerX.BannerX.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Document(collection = "lenderConfig")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Lender {

    @Id
    private String id;

    private String title;
    private List<Screens> screens;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Screens {
        private String screenTitle;
        private List<Field> fields;


        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Field {
            private String name;
            private String example;
            private String type;
            private boolean required;
            private List<String> options;

        }
    }

}
