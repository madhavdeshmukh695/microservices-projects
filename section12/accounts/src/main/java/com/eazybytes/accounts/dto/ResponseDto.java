package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold Successful Response information"
)
public class ResponseDto {
    @Schema(
            description = "Status Code of the response")
    private String statusCode;

    @Schema(
            description = "Status message of the response",
            example = "Request processed successfully"
    )
    private String statusMessage;
}
