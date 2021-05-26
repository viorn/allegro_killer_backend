package com.allergo_killer.backend.rest

import com.allergo_killer.backend.entities.Hotbed
import com.allergo_killer.backend.repositories.HotbedRepository
import com.allergo_killer.backend.tools.createCircle
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotbed")
class HotbedRestController(
        val hotbedRepository: HotbedRepository
) {
    @GetMapping
    suspend fun getAround(lat: Double? = null,
                          lng: Double? = null): Iterable<Hotbed?>? {
        return hotbedRepository.findInPolygon(createCircle(
            lat!!, lng!!, 10000.0
        ))
    }

    data class AddHotbedRequest(
        val lat: Double? = null,
        val lng: Double? = null,
        val title: String? = null,
        val body: String? = null
    )
    @PostMapping
    suspend fun addHotbed(@RequestBody hotbedRequest: AddHotbedRequest) {
        val point = GeometryFactory().createPoint(Coordinate(hotbedRequest.lat!!, hotbedRequest.lng!!))
        hotbedRepository.save(Hotbed(
            body = hotbedRequest.body!!,
            title = hotbedRequest.title!!,
            position = point
        ))
    }
}