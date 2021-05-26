package com.allergo_killer.backend.repositories

import com.allergo_killer.backend.entities.Hotbed
import org.locationtech.jts.geom.Geometry
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

interface HotbedRepository : PagingAndSortingRepository<Hotbed?, Long?> {
    @Query("select h from Hotbed h where intersects(h.position, :polygon) = true")
    fun findInPolygon(polygon: Geometry): Iterable<Hotbed>
}