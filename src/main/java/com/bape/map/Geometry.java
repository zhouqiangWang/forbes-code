package com.bape.map;

public class Geometry {
    private Location location;
    private String location_type;

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Geometry{");
        sb.append("location=").append(location);
        sb.append(", location_type='").append(location_type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
