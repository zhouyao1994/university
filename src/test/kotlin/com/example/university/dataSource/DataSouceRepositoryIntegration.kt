package com.example.university.dataSource

import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DataSouceRepositoryIntegration {

    @Autowired
    lateinit var dsRepository: DataSourceRepository

    var logger = LogManager.getLogger(DataSouceRepositoryIntegration::class.java)

    @Test
    fun `thes insert into database`() {
        dsRepository.save(DataSource("iris", "life"))
        dsRepository.save(DataSource("iris", "life"))
        dsRepository.save(DataSource("iris", "life22"))
        dsRepository.save(DataSource("iris", "lifexx"))
        dsRepository.save(DataSource("iris", "life66"))
        dsRepository.save(DataSource("iris", "life"))


        assertThat(true).isEqualTo(true)
    }


    @Test
    fun `thest insert `() {
        val rs = dsRepository.findAllById(1L)!!
        assertThat(rs[0].name).isEqualTo("iris")
    }

    @Test
    fun `logger the data`() {
        val rs = dsRepository.findAll()
        rs.map {
            logger.info(it)
        }
        assertThat(dsRepository.count()).isEqualTo(6)

    }


    @Test
    fun `count all by area`() {

    }

    @Test
    fun `find by name demo`() {
        val rs = dsRepository.findByName("iris")!!
        rs.map {
            assertThat(it.name).isEqualTo("iris")
            logger.info(it)
        }
    }

    @Test
    fun `find by area`() {
        val rs = dsRepository.findByArea("life")!!
        rs.map {
            logger.info(it)
        }
    }

}