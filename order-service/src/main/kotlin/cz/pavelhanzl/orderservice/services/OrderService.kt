package cz.pavelhanzl.orderservice.services

import cz.pavelhanzl.orderservice.model.OrderRepository
import cz.pavelhanzl.orderservice.model.ShopOrder
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class OrderService(private val orderRepository: OrderRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val order: ShopOrder = ShopOrder(0L,"Lorem Ipsum", 2.33)
        orderRepository.save(order)
    }
}