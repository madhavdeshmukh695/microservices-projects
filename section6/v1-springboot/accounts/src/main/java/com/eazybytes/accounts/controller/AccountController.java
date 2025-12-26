package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constant.AccountsConstants;
import com.eazybytes.accounts.dto.AccountContactInfoDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD operation related to Accounts service",
        description = "Operations related to Accounts service like createAccount, fetchAccountDetails, updateAccountDetails, deleteAccountDetails"
)
@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AccountController {

    private final IAccountService iAccountService;

    private final Environment environment;

    private final AccountContactInfoDto accountContactInfoDto;

    public AccountController(IAccountService iAccountService, Environment environment, AccountContactInfoDto accountContactInfoDto) {
        this.iAccountService = iAccountService;
        this.environment = environment;
        this.accountContactInfoDto = accountContactInfoDto;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Operation(
            summary = "Hello from Accounts",
            description = "Hello from Accounts"
    )
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Accounts";
    }

    @Operation(
            summary = "Create account rest api",
            description = "Rest API to Create account and Customer inside EazyBank"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Account created successfully",
            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
    )
    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "fetch Customeraccount rest api",
            description = "Rest API to fetch details of account and Customer inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Account fetched successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "fetch operation failed. Please try again or contact Dev team",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    }
    )
    @GetMapping("/fetchAccountDetails")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Invalid mobile number") String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccountDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(
            summary = "Update account rest api",
            description = "Rest API to Update account and Customer inside EazyBank"
    )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Account updated successfully"
                ),
                @ApiResponse(
                        responseCode = "417",
                        description = "Update operation failed. Please try again or contact Dev team",
                        content = @Content(
                                schema = @Schema(implementation = ErrorResponseDto.class))
                )
        })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccountDetails(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417 , AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Customeraccount rest api",
            description = "Rest API to Delete account and Customer inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Account Deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Delete operation failed. Please try again or contact Dev team"
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Invalid mobile number") String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccountDetails(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417 , AccountsConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(
            summary = "get build information",
            description = "get build information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "http status ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "http status internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    }
    )
    @GetMapping("/getBuildInfo")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @Operation(
            summary = "get build information",
            description = "get build information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "http status ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "http status internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    }
    )
    @GetMapping("/getJdkVersion")
    public ResponseEntity<String> getJdkVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("MAVEN_HOME"));
    }

    @Operation(
            summary = "get AccountContactDetails",
            description = "get AccountContactDetails"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "http status ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "http status internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDto> getAccountContactDetails() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountContactInfoDto);
    }
}
