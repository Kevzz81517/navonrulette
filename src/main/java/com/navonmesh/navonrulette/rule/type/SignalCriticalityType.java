package com.navonmesh.navonrulette.rule.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SignalCriticalityType {
    HIGH(0.5, AlertSeverityType.HIGH),
    MEDIUM(0.3, AlertSeverityType.MEDIUM),
    LOW(0.2, AlertSeverityType.LOW);

    private double weightage;

    private AlertSeverityType alertSeverity;

    public static SignalCriticalityType getByAlertSeverityType(AlertSeverityType alertSeverity) {

        return Arrays.stream(SignalCriticalityType.values())
                .filter(signalCriticalityType -> signalCriticalityType.getAlertSeverity().equals(alertSeverity))
                .findFirst().get();
    }
}
