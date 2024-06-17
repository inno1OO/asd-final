package edu.miu.asd.demo.service;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.request.ProductRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.dto.response.ProductResponseDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto);
    Optional<CustomerResponseDto> getCustomer(Long id);
}
