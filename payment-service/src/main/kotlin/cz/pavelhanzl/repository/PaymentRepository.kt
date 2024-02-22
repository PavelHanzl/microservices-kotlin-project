package cz.pavelhanzl.repository

import cz.pavelhanzl.model.PaymentStatus
import cz.pavelhanzl.model.ShopPayment
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PaymentRepository : JpaRepository<ShopPayment,Long> {
    fun findByPaymentStatus(status: PaymentStatus): List<ShopPayment>
}