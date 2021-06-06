package com.bape.map;

public
class Location {
    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append('}');
        return sb.toString();
    }
}