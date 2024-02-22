package cz.pavelhanzl.model

import io.micronaut.serde.annotation.Serdeable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import io.micronaut.serde.annotation.Serdeable.Serializable
import jakarta.persistence.*

/**
 * This class represents a payment made in a shop.
 *
 * @property id The unique identifier for the payment.
 * @property price The amount of the payment.
 * @property status The status of the payment.
 * @property orderId The id of the order associated with the payment.
 */
@Serializable
@Deserializable
@Entity
@Table(name = "ShopPayments")
data class ShopPayment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    var id: Long = 0,

    @Column(name = "price", nullable = false)
    var price: Double,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var paymentStatus: PaymentStatus,

    @Column(name = "order_id", nullable = false)
    var orderId: Long
)


