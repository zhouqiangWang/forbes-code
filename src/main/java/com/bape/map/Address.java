package com.bape.map;

public class Address {
    private String addressComponents;
    private String formattedAddress;
    Geometry geometry;
    String placeId;
    String plusCode;
    String[] types;

    public Geometry getGeometry() {
        return geometry;
    }
}
