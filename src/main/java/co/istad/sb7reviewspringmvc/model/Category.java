package co.istad.sb7reviewspringmvc.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private Integer id;
    private String name;
    private String description;
}
