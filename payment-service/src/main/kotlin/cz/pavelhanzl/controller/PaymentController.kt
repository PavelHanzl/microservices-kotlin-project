package cz.pavelhanzl.controller

import cz.pavelhanzl.model.PaymentStatus
import cz.pavelhanzl.model.ShopPayment
import cz.pavelhanzl.service.PaymentService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller
class PaymentController (
    private val paymentService: PaymentService
)
{
    @Post("/payments")
    fun createPayment(@Body shopPayment: ShopPayment): HttpResponse<ShopPayment> {
        val createdPayment: ShopPayment = paymentService.createPayment(shopPayment)
        return HttpResponse.created(createdPayment)
    }

    @Put("/payments/{id}")
    fun updatePayment(@PathVariable id: Long, @Body shopPayment: ShopPayment): HttpResponse<ShopPayment> {
        val updatedPayment: ShopPayment? = paymentService.updatePayment(id, shopPayment)
        return if (updatedPayment != null) {
            HttpResponse.ok(updatedPayment)
        } else {
            HttpResponse.notFound()
        }
    }

    @Delete("/payments/{id}")
    fun deletePayment(@PathVariable id: Long): HttpResponse<Unit> {
        val deletedPayment: Boolean = paymentService.deletePayment(id)
        return if (deletedPayment) {
            HttpResponse.noContent()
        } else {
            HttpResponse.notFound()
        }
    }

    @Get("/payments")
    fun getAllPayments(): HttpResponse<List<ShopPayment>> {
        val payments = paymentService.getAllPayments()
        return HttpResponse.ok(payments)
    }

    @Get("/payments/{id}")
    fun getPaymentById(@PathVariable id: Long): HttpResponse<ShopPayment> {
        val payment: ShopPayment? = paymentService.getPaymentById(id)
        return if (payment != null) {
            HttpResponse.ok(payment)
        } else {
            HttpResponse.notFound()
        }
    }

    @Get("/payments/status/{status}")
    fun getPaymentsByStatus(@PathVariable status: PaymentStatus): HttpResponse<List<ShopPayment>> {
        val payments: List<ShopPayment> = paymentService.getPaymentsByStatus(status)
        return HttpResponse.ok(payments)
    }
}