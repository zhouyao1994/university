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
        dsRepository.save(DataSource(1, "iris", "400", "4", "university", "classification", "life"))
        dsRepository.save(DataSource(2, "iris", "400", "4", "university", "classification", "life"))
        dsRepository.save(DataSource(3, "iris", "400", "4", "university", "classification", "life"))
        dsRepository.save(DataSource(4, "iris", "400", "4", "university", "classification", "life"))
        dsRepository.save(DataSource(5, "iris", "400", "4", "university", "classification", "life"))
        dsRepository.save(DataSource(6, "iris", "400", "4", "university", "classification", "life"))


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



}