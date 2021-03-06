package org.ovirt.engine.core.common.businessentities;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NetworkStatus")
public enum NetworkStatus {
    NonOperational(0),
    Operational(1);

    private int intValue;
    private static Map<Integer, NetworkStatus> mappings;

    static {
        mappings = new HashMap<Integer, NetworkStatus>();
        for (NetworkStatus error : values()) {
            mappings.put(error.getValue(), error);
        }
    }

    private NetworkStatus(int value) {
        intValue = value;
    }

    public int getValue() {
        return intValue;
    }

    public static NetworkStatus forValue(int value) {
        return mappings.get(value);
    }
}
