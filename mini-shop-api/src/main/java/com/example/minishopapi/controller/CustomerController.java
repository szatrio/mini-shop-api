package com.example.minishopapi.controller;

import com.example.minishopapi.model.CreateCustomerRequest;
import com.example.minishopapi.model.CustomerResponse;
import com.example.minishopapi.model.UpdateCustomerRequest;
import com.example.minishopapi.model.WebResponse;
import com.example.minishopapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(
            path = "/api/customers",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<CustomerResponse> create(@RequestBody CreateCustomerRequest request){
        CustomerResponse customerResponse = customerService.create(request);
        return WebResponse.<CustomerResponse>builder().data(customerResponse).build();
    }

    @PutMapping(
            path = "/api/customers/{customerId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<CustomerResponse> update(@RequestBody UpdateCustomerRequest request,
                                            @PathVariable("customerId") String customerId
    ){
        request.setId(customerId);

        CustomerResponse customerResponse = customerService.update(request);
        return WebResponse.<CustomerResponse>builder()
                .data(customerResponse)
                .build();
    }

    @GetMapping(
            path = "/api/customers/{customerId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<CustomerResponse> get(@PathVariable("customerId") String customerId ){
        CustomerResponse customerResponse = customerService.get(customerId);
        return WebResponse.<CustomerResponse>builder()
                .data(customerResponse)
                .build();
    }

    @GetMapping(
            path = "/api/customers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<CustomerResponse>> getList(){
        List<CustomerResponse> customerResponse = customerService.getList();
        return WebResponse.<List<CustomerResponse>>builder()
                .data(customerResponse)
                .build();
    }
}
