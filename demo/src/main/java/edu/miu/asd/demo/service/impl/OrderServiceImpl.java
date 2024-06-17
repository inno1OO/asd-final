package edu.miu.asd.demo.service.impl;

import edu.miu.asd.demo.dto.request.CustomerRequestDto;
import edu.miu.asd.demo.dto.request.OrderRequestDto;
import edu.miu.asd.demo.dto.response.CustomerResponseDto;
import edu.miu.asd.demo.dto.response.OrderResponseDto;
import edu.miu.asd.demo.model.Customer;
import edu.miu.asd.demo.model.Order;
import edu.miu.asd.demo.repository.CustomerRepository;
import edu.miu.asd.demo.repository.OrderRepository;
import edu.miu.asd.demo.service.CustomerService;
import edu.miu.asd.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<OrderResponseDto> addOrder(OrderRequestDto orderRequestDto) {
        Order order = modelMapper.map(orderRequestDto, Order.class);
        Order savedOrder = orderRepository.save(order);
        OrderResponseDto orderResponseDto = modelMapper.map(savedOrder, OrderResponseDto.class);
        return Optional.of(orderResponseDto);

        //new way to add an order
//        Order newOrder = new Order();
//        newOrder.setOrderDate(orderRequestDto.getOrderDate());
//        newOrder.setCustomer(
//                new Customer(
//                        orderRequestDto.getCustomerRequestDto().getName()
//        );
//        Order publisher = orderRepository.save(newOrder);
//        OrderRequestDto responseDto = new OrderRequestDto();
//        responseDto.setOrderDate(publisher.getOrderDate());
//
//        responseDto.setCustomerRequestDto(new CustomerRequestDto(publisher.getCustomer().getName()));
//        return Optional.of(responseDto);
    }



    @Override
    public Optional<OrderResponseDto> getOrder(Long id) {
        Optional<Order> foundOrder = orderRepository.findById(id);
        if (foundOrder.isPresent()) {
            OrderResponseDto orderResponseDto = modelMapper.map(foundOrder.get(), OrderResponseDto.class);
            return Optional.of(orderResponseDto);
        }
        return Optional.empty();
    }

//    @Override
//    public Page<OrderResponseDto> findAll(int customerId, int pageNumber, int pageSize, String direction, String sortBy) {
//        Pageable pageable = PageRequest.of(
//                customerId,
//                pageNumber,
//                pageSize,
//                Direction.fromString(direction),
//                sortBy
//        );
//        //It returns a page(mentioned in pageable object) of book entities
//        Page<Order> orderPage = orderRepository.findAll(pageable);
//        List<OrderResponseDto> orderResponseDtoList =
//                orderPage.stream()
//                        .map(order -> modelMapper.map(order, OrderResponseDto.class))
//                        .collect(Collectors.toList());
//        System.out.println("Intermediate result: " + orderResponseDtoList);
//        return new PageImpl<>(
//                orderResponseDtoList,
//                pageable,
//                orderPage.getTotalElements()
//        );
//    }

}
