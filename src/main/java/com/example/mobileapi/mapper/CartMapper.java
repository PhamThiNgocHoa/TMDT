package com.example.mobileapi.mapper;

import com.example.mobileapi.dto.request.CartRequestDTO;
import com.example.mobileapi.dto.response.CartResponseDTO;
import com.example.mobileapi.dto.response.ProductColorResponseDTO;
import com.example.mobileapi.entity.Cart;
import com.example.mobileapi.entity.ProductColor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface CartMapper {
    Cart toCart(CartRequestDTO dto);
    CartResponseDTO toCartResponseDTO(Cart cart);
}

