package com.example.mapsapp.Model;

public class PlaceModel {
    public PlaceModel() {
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    int placeID;
    String placeName;
    String placeAddress;

    public PlaceModel(int placeID, String placeName, String placeAddress) {
        this.placeID = placeID;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
    }


}


