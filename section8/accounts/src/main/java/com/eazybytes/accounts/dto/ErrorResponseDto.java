package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Error Response"
)
public class ErrorResponseDto {
    @Schema(description = "Api path invoked by user")
    private String apiPath;

    @Schema(description = "Error code")
    private HttpStatus errorCode;

    @Schema(description = "Error message")
    private String errorMessage;

    @Schema(description = "Error time")
    private LocalDateTime errorTime;
}
