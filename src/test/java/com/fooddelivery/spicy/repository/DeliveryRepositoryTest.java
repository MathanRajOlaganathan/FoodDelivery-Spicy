package com.fooddelivery.spicy.repository;

import com.fooddelivery.spicy.entity.DeliveryExecutive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DeliveryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DeliveryExecutiveRepository deliveryRepository;


    @Test
    public void getDeliveryExecutiveByDeIdTest() {
        entityManager.persist(new DeliveryExecutive("p343","Rahul","Raj","1234567890",200.00,1000.00,15000.00));
        DeliveryExecutive deliveryExecutive = deliveryRepository.getDeliveryExecutiveByDeId("p343").get();
        assertEquals("Rahul", deliveryExecutive.getFirstName());
    }
}
