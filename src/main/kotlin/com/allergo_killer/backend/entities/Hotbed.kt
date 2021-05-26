package com.allergo_killer.backend.entities

import org.locationtech.jts.geom.Point
import javax.persistence.*

@Entity
data class Hotbed (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        val title: String,
        val body: String,
        val position: Point,
        @ManyToMany(fetch = FetchType.EAGER)
        val images: List<Image> = emptyList()
)