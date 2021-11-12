package com.laptrinhjavaweb.dto.request;

public class BuildingSearchRequest {
    private Integer id;
    private String managerName;
    private String managerPhone;
    private Integer serviceFee;
    private Integer brokerAgeFee;
    private String name;
    private String district;
    private Integer floorArea;
    private String street;
    private String ward;
    private Integer numberOfBasement;
    private String[] buildingTypes = new String[] {};
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private Integer areaRentFrom;
    private Integer areaRentTo;
    private Integer staffId;

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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingArea() {
        return floorArea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getBrokerAgeFee() {
        return brokerAgeFee;
    }

    public void setBrokerAgeFee(Integer brokerAgeFee) {
        this.brokerAgeFee = brokerAgeFee;
    }

    public void setBuildingArea(Integer buildingArea) {
        this.floorArea = buildingArea;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Integer rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Integer rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public Integer getAreaRentFrom() {
        return areaRentFrom;
    }

    public void setAreaRentFrom(Integer areaRentFrom) {
        this.areaRentFrom = areaRentFrom;
    }

    public Integer getAreaRentTo() {
        return areaRentTo;
    }

    public void setAreaRentTo(Integer areaRentTo) {
        this.areaRentTo = areaRentTo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

}
