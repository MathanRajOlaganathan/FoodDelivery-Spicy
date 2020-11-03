package com.fooddelivery.spicy.config;

import com.fooddelivery.spicy.common.StringToEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }
}
