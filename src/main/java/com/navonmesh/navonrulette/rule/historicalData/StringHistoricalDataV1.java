package com.navonmesh.navonrulette.rule.historicalData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringHistoricalDataV1 {


    private String current;

    private String tMinus1;

    private String tMinus2;

    private String tMinus3;

    private String tMinus4;

    private String tMinus5;

    private String tMinus6;
}
