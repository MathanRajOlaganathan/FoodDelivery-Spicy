package com.fooddelivery.spicy.repository;

import com.fooddelivery.spicy.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Repository
public interface CustomerRespository extends CrudRepository<Customer,Long> {
}
