package com.example.minishopapi.service;

import com.example.minishopapi.entity.Customer;
import com.example.minishopapi.model.CreateCustomerRequest;
import com.example.minishopapi.model.CustomerResponse;
import com.example.minishopapi.model.UpdateCustomerRequest;
import com.example.minishopapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public CustomerResponse create(CreateCustomerRequest request){
        validationService.validate(request);

        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setCreatedAt(getCurrentTimestamp());

        customerRepository.save(customer);

        return toCustomerResponse(customer);
    }

    private CustomerResponse toCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }

    @Transactional
    public CustomerResponse update(UpdateCustomerRequest request){
        validationService.validate(request);

        Customer customer = customerRepository.findById(request.getId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setUpdatedAt(getCurrentTimestamp());
        customerRepository.save(customer);

        return toCustomerResponse(customer);
    }

    @Transactional(readOnly = true)
    public CustomerResponse get(String id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        return toCustomerResponse(customer);
    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> getList(){
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(this::toCustomerResponse)
                .toList();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
