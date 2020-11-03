package com.fooddelivery.spicy.exception;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private List<String> details;

}
