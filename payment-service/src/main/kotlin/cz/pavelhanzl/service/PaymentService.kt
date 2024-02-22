package cz.pavelhanzl.service

import cz.pavelhanzl.model.PaymentStatus
import cz.pavelhanzl.model.ShopPayment
import cz.pavelhanzl.repository.PaymentRepository
import jakarta.inject.Singleton

/**
 * This class represents a service for handling payments in a shop.
 *
 * @property paymentRepository The repository for managing shop payments.
 */
@Singleton
class PaymentService(
    private val paymentRepository: PaymentRepository
) {
    fun createPayment(shopPayment: ShopPayment) : ShopPayment {
       return paymentRepository.save(shopPayment)
    }

    fun getAllPayments(): List<ShopPayment> {
        return paymentRepository.findAll().toList()
    }

    fun updatePayment(id: Long, shopPayment: ShopPayment): ShopPayment? {

        val existingPayment = paymentRepository.findById(id)
        if (existingPayment.isPresent) {
            val payment = existingPayment.get()
            payment.price = shopPayment.price
            payment.paymentStatus = shopPayment.paymentStatus
            payment.orderId = shopPayment.orderId
            return paymentRepository.update(payment)
        } else {
            return null
        }


    }

    fun deletePayment(id: Long): Boolean {
        paymentRepository.deleteById(id)
        return !paymentRepository.existsById(id)
    }

    fun getPaymentById(id: Long): ShopPayment? {
        return paymentRepository.findById(id).orElse(null)
    }

    fun getPaymentsByStatus(status: PaymentStatus): List<ShopPayment> {

        return paymentRepository.findByPaymentStatus(status)

    }
}