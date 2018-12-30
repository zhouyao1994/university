package com.example.university.dataSource

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
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
class DataSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
    var name: String = ""//数据名称
    var recoourdnum: String = ""//记录count
    var feildNum: String = ""//字段count
    var fromSource: String = ""//数据库来源
    var associatTask: String = ""
    var area: String = ""

    protected constructor() {}
    constructor(name: String, area: String) {
        this.name = name
        this.area = area
    }
}

//@Entity
//class DataSource {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    val id: Long? = null
//    var name: String = ""
//    var area: String = ""
//
//    protected constructor() {}
//    constructor(name: String, area: String) {
//        this.name = name
//        this.area = area
//    }
//
//    override fun toString(): String {
//        return "DataSource(id=$id, name='$name', area='$area')"
//    }
//
//}


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