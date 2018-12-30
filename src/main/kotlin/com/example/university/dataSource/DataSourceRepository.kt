package com.example.university.dataSource

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface DataSourceRepository : CrudRepository<DataSource, Long> {
    fun findAllById(id: Long): List<DataSource>?
//    fun findByArea(area: String): DataSource?
}