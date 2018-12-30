package com.example.university.dataSource

import javax.persistence.Entity
import javax.persistence.Id


/**
 * 元数据表，表示每个数据字段的名称，类型，是否可枚举
 */
@Entity
data class DataSourceFeild(
        @Id
        var id: Long,
        var feildName: String,//属性名
        var feildType: String,//字段类型，0-数字，1-字符，2-二进制，
        var dataSourceId: Long,//数据库ID
        var isEmue: Int
)

/**
 * 数据源信息，包括，数据源名称，有多少记录，有多少字段，数据库的来源等
 */
@Entity
data class DataSource(
        @Id
        var id: Long,
        var name: String,//数据名称
        var recordNum: String,//记录count
        var feildNum: String,//字段count
        var fromSource: String,//数据库来源
        var associatTask: String,
        var Area:String
)

/**
 * 数据库层，只做存储，不做计算运算，所有所有数据都存为string类型
 */
@Entity
data class DataEnity(
        @Id
        var id: Long,
        var feildId: Long,
        var value: String//统一按String类型存储
)