package com.navonmesh.navonrulette.rule.historicalData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoubleHistoricalDataV1 {

    private Double current;

    private Double tMinus1;

    private Double tMinus2;

    private Double tMinus3;

    private Double tMinus4;

    private Double tMinus5;

    private Double tMinus6;
}
