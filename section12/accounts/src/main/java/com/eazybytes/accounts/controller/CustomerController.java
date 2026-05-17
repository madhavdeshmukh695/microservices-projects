package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.CustomersDetailsDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Rest API fro customers in eazy bank",
        description = "Operations related to fetch Customers details "
)
@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CustomerController {


    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

    @Operation(
            summary = "Fetch customer details rest API",
            description = "Rest API to fetch customersDetails"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "http status ok  "
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "fetch operation failed. Please try again or contact Dev team",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    }
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomersDetailsDto> fetchCustomersDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestParam @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Invalid mobile number") String mobileNumber) {

        logger.debug("Eazybank-corelation-id found: {}", correlationId);
        CustomersDetailsDto cd = iCustomerService.fetchCustomersDetails(mobileNumber, correlationId);

        return ResponseEntity.status(HttpStatus.OK).body(cd);
    }
}
