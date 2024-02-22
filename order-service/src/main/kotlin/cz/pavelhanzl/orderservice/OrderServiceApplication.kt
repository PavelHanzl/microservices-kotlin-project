package cz.pavelhanzl.orderservice

import cz.pavelhanzl.orderservice.model.ShopOrder
import cz.pavelhanzl.orderservice.model.OrderRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderServiceApplication

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)

}
