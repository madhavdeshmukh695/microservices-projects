package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * Create account
     * @param customerDto -CusterDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     */
    CustomerDto fetchAccountDetails(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return
     */
    boolean updateAccountDetails(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteAccountDetails(String mobileNumber);
}
