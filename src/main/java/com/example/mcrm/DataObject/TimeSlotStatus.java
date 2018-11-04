package com.example.mcrm.DataObject;

public enum  TimeSlotStatus {
    FREE {
        @Override
        String getCode() {
            return "FREE";
        }
    },
    RESERVED {
        @Override
        String getCode() {
            return "RESERVED";
        }
    };

    abstract String getCode();
}
