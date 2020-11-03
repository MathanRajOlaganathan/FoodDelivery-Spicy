package com.fooddelivery.spicy.common;

import com.fooddelivery.spicy.entity.enums.CurrentState;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
public class StringToEnumConverter implements Converter<String,CurrentState> {
   @Override
   public CurrentState convert(String source) {
       return CurrentState.valueOf(source.toUpperCase());
   }
}
