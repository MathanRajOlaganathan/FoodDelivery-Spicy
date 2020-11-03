# FoodDelivery-Spicy
Rest API for Delivery Executives


## Requirements

1. Java - 1.11

2. Maven - 3.x.x

3. Spring Boot - 2.3.X

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/MathanRajOlaganathan/FoodDelivery-Spicy.git
```

**2. Build and run the app using maven**

```bash
cd FoodDelivery-Spicy
mvn package
java -jar target/spicy-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```
Alternatively, you can run the built  jar which is  placed under FoodDelivery-Spicy directory -

```bash
java -jar target/spicy-1.0.0.jar
```


The server will start at <http://localhost:8080>.

The swagger will start at <http://localhost:8080/swagger-ui/>.

## Exploring the Rest APIs

The application defines following REST APIs

```
1. GET /api/de/{deId} - Retrieves delivery executive details using de id

2. GET /api/de/allOrders - Retrieves all the newly created orders


3. GET /api/de/history/{deId}- Retrieves all the orders handled by the delivery executive using de id

4. GET ​/api​/de​/order​/{deId} - Retrieves the accepted order details using de id

5.PATCH /api/de/update/{deId} - Update the order state using the order id and state

```






