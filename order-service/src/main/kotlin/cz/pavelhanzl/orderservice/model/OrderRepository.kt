package cz.pavelhanzl.orderservice.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<ShopOrder, Long>