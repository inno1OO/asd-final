package edu.miu.asd.demo.controller;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.exception.customer.CustomerNotFoundException;
import edu.miu.asd.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> addCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        Optional<CustomerResponseDto> responseDto = customerService.addCustomer(customerRequestDto);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long id) {
        Optional<CustomerResponseDto> responseDto = customerService.getCustomer(id);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        throw new CustomerNotFoundException(id + " not found");
//        return ResponseEntity.notFound().build();
    }
}
