package com.example.university

import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class User(
        @Id
        var id: Int,
        var firstName: String,
        var lastName: String,
        var sccore: Float,
        var address: String
)

@Entity
data class MiningMethod(
        @Id
        var id: Int,
        var dataSourceId: Int,
        var miningType: Int,
        val createTime: Timestamp
)

