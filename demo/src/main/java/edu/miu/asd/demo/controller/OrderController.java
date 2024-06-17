package edu.miu.asd.demo.controller;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.request.OrderRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.dto.response.OrderResponseDto;
import edu.miu.asd.demo.exception.customer.CustomerNotFoundException;
import edu.miu.asd.demo.service.CustomerService;
import edu.miu.asd.demo.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> addOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {
        Optional<OrderResponseDto> responseDto = orderService.addOrder(orderRequestDto);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long id) {
        Optional<OrderResponseDto> responseDto = orderService.getOrder(id);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        throw new CustomerNotFoundException(id + " not found");
//        return ResponseEntity.notFound().build();
    }
//
//    @GetMapping("/{customerId}/{pageNumber}/{pageSize}/{sortDirection}/{sortBy}")
//    public ResponseEntity<List<OrderResponseDto>> getAllBooks(
//
//            @PathVariable Integer pageSize,
//            @PathVariable String sortDirection,
//            @PathVariable String sortBy,
//            @PathVariable   Integer customerId,
//            @PathVariable Integer pageNumber
//
//
//    ) {
//        Page<OrderResponseDto> orderResponseDtos =
//                orderService.findAll(customerId, pageNumber, pageSize, sortDirection, sortBy);
//        if (orderResponseDtos.getTotalElements() > 0) {
//            return ResponseEntity.ok(orderResponseDtos.getContent());
//        }
//        return ResponseEntity.noContent().build();
//    }
}

