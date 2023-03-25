package com.navonmesh.navonrulette.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Institution {

    private String institutionPackage;

    private String apiKey;

    private List<Product> products;
}
