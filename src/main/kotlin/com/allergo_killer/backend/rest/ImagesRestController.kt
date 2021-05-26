package com.allergo_killer.backend.rest

import com.allergo_killer.backend.entities.Hotbed
import com.allergo_killer.backend.repositories.HotbedRepository
import kotlinx.coroutines.flow.Flow
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/image")
class ImagesRestController(
    val hotbedRepository: HotbedRepository
) {
    @PostMapping
    suspend fun add(@RequestParam("file") file: MultipartFile) {

    }
}