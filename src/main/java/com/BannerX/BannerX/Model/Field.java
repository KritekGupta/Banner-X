package com.BannerX.BannerX.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Field {
    private String label;
    private String name;
    private String type;
    private boolean required;

    private List<String> options;
}
