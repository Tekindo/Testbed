package com.gard.testbed.engine.petrinet;

/**
 * Created by Chris on 02/03/2016.
 */
public class Token {

    Place currentLocation;

    public void setCurrentLocation(Place place) {
        currentLocation = place;
    }

    public Place getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public String toString() {
        return "TOKEN: Place = " + currentLocation;
    }


}
