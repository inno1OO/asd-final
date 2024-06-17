package edu.miu.asd.demo.service;

import edu.miu.asd.demo.dto.request.ProductRequestDto;
import edu.miu.asd.demo.dto.response.ProductResponseDto;

import java.util.Optional;

public interface ProductService {
    Optional<ProductResponseDto> addProduct(ProductRequestDto productRequestDto);
    Optional<ProductResponseDto> getProduct(Long id);
}
