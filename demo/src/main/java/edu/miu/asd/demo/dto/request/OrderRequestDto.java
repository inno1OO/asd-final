package edu.miu.asd.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDate orderDate;
    private CustomerRequestDto customerRequestDto;
    private OrderRequestDto orderRequestDto;
}