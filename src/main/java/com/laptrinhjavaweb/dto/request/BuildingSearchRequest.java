package com.laptrinhjavaweb.dto.request;

import sun.font.StrikeCache;

public class BuildingSearchRequest {
    private String name;
    private String district;
    private String buildingArea;
    private String street;
    private String ward;
    private String numberOfBasement;
    private String[] buildingTypes = new String[] {};
    private String rentPriceFrom;
    private String rentPriceTo;
    private String areaRentFrom;
    private String areaRentTo;
    private String staffId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public String getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(String rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public String getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(String rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public String getAreaRentFrom() {
        return areaRentFrom;
    }

    public void setAreaRentFrom(String areaRentFrom) {
        this.areaRentFrom = areaRentFrom;
    }

    public String getAreaRentTo() {
        return areaRentTo;
    }

    public void setAreaRentTo(String areaRentTo) {
        this.areaRentTo = areaRentTo;
    }


}
