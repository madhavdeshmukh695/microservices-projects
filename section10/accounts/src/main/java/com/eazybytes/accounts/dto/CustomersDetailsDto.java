package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer and Account cards and Loans information"
)
public class CustomersDetailsDto {
    @Schema(
            description = "Name of the customer",
            example = "John Doe"
    )
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20,   message = "Name should be between 2 and 20 characters")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "l4HdW@example.com"
    )
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email address")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "7073657899"
    )
    @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Invalid mobile number")
    private String mobileNumber;

    @Schema(
            description = "Accounts details of the customer")
    private AccountsDto accountsDto;

    @Schema(
            description = "Loan details of the customer")
    private LoansDto loansDto;

    @Schema(
            description = "Cards details of the customer")
    private CardsDto cardsDto;

}
