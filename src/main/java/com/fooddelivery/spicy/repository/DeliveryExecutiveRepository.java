package com.fooddelivery.spicy.repository;

import com.fooddelivery.spicy.entity.DeliveryExecutive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Repository
public interface DeliveryExecutiveRepository extends CrudRepository<DeliveryExecutive,Long> {

    public Optional<DeliveryExecutive> getDeliveryExecutiveByDeId(String deId);
}
