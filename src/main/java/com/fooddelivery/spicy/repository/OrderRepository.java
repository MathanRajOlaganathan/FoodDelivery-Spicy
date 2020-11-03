package com.fooddelivery.spicy.repository;

import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    public Optional<Order> findOrderByDeIdAndCurrentState(String deId, CurrentState currentState);

    public Optional<List<Order>> findOrderByCurrentStateOrderByPlacedDateAsc(CurrentState currentState);

    public Optional<List<Order>> findAllByDeId(String deId);

    @Modifying
    @Query("update Order o set o.currentState=:state where o.orderId=:orderId")
    @Transactional
    public void updateOrderState(@Param(value = "orderId") String orderId, @Param(value = "state") CurrentState state);
}
