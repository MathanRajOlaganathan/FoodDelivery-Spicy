package com.fooddelivery.spicy.exception;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
public class OrderNotAvaialableException extends RuntimeException {
    public OrderNotAvaialableException(String message) {
        super(message);
    }
}
