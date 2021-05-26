package com.allergo_killer.backend.tools

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.Geometry

import org.locationtech.jts.util.GeometricShapeFactory


fun createCircle(lat: Double, lng: Double, radius: Double): Geometry {
    val shapeFactory = GeometricShapeFactory()
    shapeFactory.setNumPoints(32)
    shapeFactory.setCentre(Coordinate(lat, lng))
    shapeFactory.setSize(radius * 2)
    return shapeFactory.createCircle()
}