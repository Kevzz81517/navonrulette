package com.navonmesh.navonrulette.rule.historicalData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarHistoricalDataV1 {

    private Calendar current;

    private Calendar tMinus1;

    private Calendar tMinus2;

    private Calendar tMinus3;

    private Calendar tMinus4;

    private Calendar tMinus5;

    private Calendar tMinus6;
}
