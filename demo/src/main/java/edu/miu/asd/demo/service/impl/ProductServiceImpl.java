package edu.miu.asd.demo.service.impl;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.request.ProductRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.dto.response.ProductResponseDto;
import edu.miu.asd.demo.model.Customer;
import edu.miu.asd.demo.model.Product;
import edu.miu.asd.demo.repository.CustomerRepository;
import edu.miu.asd.demo.repository.ProductRepository;
import edu.miu.asd.demo.service.CustomerService;
import edu.miu.asd.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ProductResponseDto> addProduct(ProductRequestDto productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        Product savedProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = modelMapper.map(savedProduct, ProductResponseDto.class);
        return Optional.of(productResponseDto);
    }
    @Override
    public Optional<ProductResponseDto> getProduct(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (foundProduct.isPresent()) {
            ProductResponseDto productResponseDto = modelMapper.map(foundProduct.get(), ProductResponseDto.class);
            return Optional.of(productResponseDto);
        }
        return Optional.empty();
    }

}