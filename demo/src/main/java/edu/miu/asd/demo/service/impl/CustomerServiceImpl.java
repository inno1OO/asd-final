package edu.miu.asd.demo.service.impl;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.model.Customer;
import edu.miu.asd.demo.repository.CustomerRepository;
import edu.miu.asd.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = modelMapper.map(savedCustomer, CustomerResponseDto.class);
        return Optional.of(customerResponseDto);
    }
    @Override
    public Optional<CustomerResponseDto> getCustomer(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isPresent()) {
            CustomerResponseDto customerResponseDto = modelMapper.map(foundCustomer.get(), CustomerResponseDto.class);
            return Optional.of(customerResponseDto);
        }
        return Optional.empty();
    }

}
