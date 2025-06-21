package com.example.mobileapi.mapper;

import com.example.mobileapi.entity.enums.Role;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Named("CustomerMapperUtils") // Quan trọng để MapStruct nhận diện bean này
public class CustomerMapperUtils {

    @Named("booleanToRole")
    public static Role booleanToRole(boolean isAdmin) {
        return isAdmin ? Role.ADMIN : Role.USER;
    }

    @Named("roleToBoolean")
    public static boolean roleToBoolean(Role role) {
        return role == Role.ADMIN;
    }
}
