package com.example.university.dataSource

import com.example.university.customer.Customer
import com.example.university.customer.CustomerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.math.log

@RunWith(SpringRunner::class)
@SpringBootTest
class CustorRepositoryIntegration{

    @Autowired
    lateinit var  customerRepository:CustomerRepository

    val logger = LoggerFactory.getLogger(CustomerRepository::class.java)

    @Test
    fun `test save demo`() {
        customerRepository.save(Customer("zhou", "yao"))
        customerRepository.save(Customer("zhou1", "yao"))
        customerRepository.save(Customer("zhou2", "yao"))
        customerRepository.save(Customer("zhou3", "yao"))
        customerRepository.findAll().map {
            logger.info(it.toString())
        }
    }

    @Test
    fun `test get zhou`() {
        val yao = customerRepository.findByLastName("yao")
        yao.map {
            assertThat(it.lastName).isEqualTo("yao")
        }
    }
}