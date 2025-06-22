package com.example.mobileapi.entity.enums;

public enum Role {
    ADMIN(1),
    USER(0),
    STAFF(2);


    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role fromValue(int value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }

    public static Role fromBoolean(boolean value) {
        return value ? ADMIN : USER;
    }

    public static boolean toBoolean(Role role) {
        return role == ADMIN;
    }
}
