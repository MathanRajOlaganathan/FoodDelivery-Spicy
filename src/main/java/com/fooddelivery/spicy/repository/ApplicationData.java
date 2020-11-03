//package com.fooddelivery.spicy.repository;
//
//import com.fooddelivery.spicy.entity.*;
//import com.fooddelivery.spicy.entity.enums.CurrentState;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//
///**
// * @author Mathan Raj O
// * @version 1.0
// * @since 02-11-2020
// */
//@Component
//public class ApplicationData implements CommandLineRunner {
//    private DeliveryExecutiveRepository deliveryExecutiveRepository;
//    private CustomerRespository customerRespository;
//    private ItemRepository itemRepository;
//    private LocationRepository locationRepository;
//    private OrderRepository orderRepository;
//    private RestaurantRepository restaurantRepository;
//
//    @Autowired
//    public ApplicationData(DeliveryExecutiveRepository deliveryExecutiveRepository, CustomerRespository customerRespository, ItemRepository itemRepository, LocationRepository locationRepository, OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
//        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
//        this.customerRespository = customerRespository;
//        this.itemRepository = itemRepository;
//        this.locationRepository = locationRepository;
//        this.orderRepository = orderRepository;
//        this.restaurantRepository = restaurantRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        deliveryExecutiveRepository.save(new DeliveryExecutive("p343","Rahul","Raj","1234567890",200.00,1000.00,15000.00));
//        deliveryExecutiveRepository.save(new DeliveryExecutive("a946","Alex","Jackson","8567912301",150.50,900.00,14000.00));
//        deliveryExecutiveRepository.save(new DeliveryExecutive("c783","Rachael","Rose","7586942314",180.50,1100.50,16500.50));
//        deliveryExecutiveRepository.save(new DeliveryExecutive("p223","David","Doss","5487960130",210.00,1050.00,17800.00));
//        deliveryExecutiveRepository.save(new DeliveryExecutive("p443","Kristina","Katherine","0987654321",290.00,1200.00,19000.00));
//
//        Order order1 = new Order("f9f363d1-e1c2-4595-b477-c649845bc953","BC953",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.DELIVERED,"p343");
//        Order order2 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.ACCEPTED,"c783");
//        Order order3 = new Order("b45453a2-21b2-9589-acsad-a949845AD224","AD224",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.CREATED,"c783");
//        Order order4 = new Order("b45453a2-21b2-9589-acasd-a949845aAD234","AD234",new SimpleDateFormat("dd/MM/yyyy").parse("01/19/2020"), CurrentState.CREATED,"c783");
//        orderRepository.save(order1);
//        orderRepository.save(order2);
//        orderRepository.save(order3);
//        orderRepository.save(order4);
//
//        Customer customerIndiana = new Customer("Josh","Woodman","7864893210",order1);
//        customerRespository.save(customerIndiana);
//        customerRespository.save(new Customer("Marry","Lilly","5689703124",order2));
//
//        itemRepository.save(new Item("Fresh-baked muffin",2,100.00,order1));
//        itemRepository.save(new Item("Chocolate deluxe",1,150.00,order2));
//
//
//        Restaurant greenwichRest = new Restaurant("Otto Enoteca & Pizzeri","https://www.restaurants.com/new-york-city/otto-enoteca-pizzeria-greenwich-village","5789134602",order1);
//        restaurantRepository.save(greenwichRest);
//
//        locationRepository.save(new Location("1 5th Avenue, New York, NY 10003","Greenwich Village","New York City","40.732013","73.996155","10003","216",greenwichRest));
//        locationRepository.save(new Location("12th Avenue, New York, NY 10203","Indian Street","New York City","40.6589313","73.98252","10045","216",customerIndiana));
//    }
//}
