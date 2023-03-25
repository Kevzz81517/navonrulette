package com.navonmesh.navonrulette.configuration.util;

import java.util.UUID;

public class UUIDUtility {

    public static UUID generate() {
        return UUID.randomUUID();
    }

    public static String generateWithoutDashes() {
        return UUIDUtility.generate().toString().replaceAll("-", "");
    }
}
