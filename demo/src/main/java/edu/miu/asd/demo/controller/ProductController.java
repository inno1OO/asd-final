package edu.miu.asd.demo.controller;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.request.ProductRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.dto.response.ProductResponseDto;
import edu.miu.asd.demo.exception.customer.CustomerNotFoundException;
import edu.miu.asd.demo.service.CustomerService;
import edu.miu.asd.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Optional<ProductResponseDto> responseDto = productService.addProduct(productRequestDto);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {
        Optional<ProductResponseDto> responseDto = productService.getProduct(id);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
//        throw new CustomerNotFoundException(id + " not found");
        return ResponseEntity.notFound().build();
    }
}

