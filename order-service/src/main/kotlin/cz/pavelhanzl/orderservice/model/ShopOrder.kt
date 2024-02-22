package cz.pavelhanzl.orderservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ShopOrders")
data class ShopOrder(
    @Id @GeneratedValue  val id : Long,
    val description: String,
    val price: Double
)
