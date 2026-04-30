package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomersDetailsDto;

public interface ICustomerService {

    CustomersDetailsDto fetchCustomersDetails(String mobileNumber, String correlationId);
}
