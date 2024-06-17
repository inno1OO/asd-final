package edu.miu.asd.demo.service;

import edu.miu.asd.demo.dto.request.OrderRequestDto;
import edu.miu.asd.demo.dto.request.ProductRequestDto;
import edu.miu.asd.demo.dto.response.OrderResponseDto;
import edu.miu.asd.demo.dto.response.ProductResponseDto;
import edu.miu.asd.demo.model.Order;

import java.util.Optional;

public interface OrderService {
    Optional<OrderResponseDto> addOrder(OrderRequestDto orderRequestDto);
    Optional<OrderResponseDto> getOrder(Long id);
}
