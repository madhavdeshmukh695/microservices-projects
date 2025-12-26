package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Scema to hold account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of the EazyBank account",
            example = "1234567890"
    )
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "[0-9]{10}", message = "Invalid account number")
    private Long accountNumber;

    @Schema(
            description = "Account type of the EazyBank account",
            example = "SAVINGS"
    )
    @NotEmpty(message = "Account type should not be empty")
    private String accountType;

    @Schema(
            description = "EazyBank branch address",
            example = "123 Main St, Anytown, USA"
    )
    @NotEmpty(message = "Branch address should not be empty")
    private String branchAddress;
}
