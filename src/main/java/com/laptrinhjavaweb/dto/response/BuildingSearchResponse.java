package com.laptrinhjavaweb.dto.response;

public class BuildingSearchResponse {
    private String name;
    private String district;
    private String floorArea;
    private String street;
    private String ward;
    private String numberOfBasement;
    private String[] buildingTypes = new String[] {};
    private String rentPriceFrom;
    private String rentPriceTo;
    private String areaRentFrom;
    private String areaRentTo;
    private String staffId;


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
    public String getName() {
        return name;
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea;
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
    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
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


    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public String getCostRentFrom() {
        return rentPriceFrom;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    private BuildingSearchResponse(Builder builder) {
        this.name = builder.name;
        this.district = builder.district;
        this.floorArea = builder.floorArea;
        this.numberOfBasement = builder.numberOfBasement;
        this.street = builder.street;
        this.ward = builder.ward;
        this.buildingTypes = builder.buildingTypes;
        this.rentPriceFrom = builder.rentpriceFrom;
        this.rentPriceTo = builder.rentpriceTo;
        this.areaRentFrom = builder.areaRentFrom;
        this.areaRentTo = builder.areaRentTo;
        this.staffId = builder.staffId;
    }

    public static class Builder {

        private String name;
        private String district;
        private String street;
        private String ward;
        private String floorArea;
        private String numberOfBasement;
        private String[] buildingTypes = new String[] {};
        private String rentpriceFrom;
        private String rentpriceTo;
        private String areaRentFrom;
        private String areaRentTo;
        private String staffId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setFloorArea(String floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setNumberOfBasement(String numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }

        public Builder setCostRentFrom(String rentpriceFrom) {
            this.rentpriceFrom = rentpriceFrom;
            return this;
        }

        public Builder setCostRentTo(String rentpriceTo) {
            this.rentpriceTo = rentpriceTo;
            return this;
        }

        public Builder setAreaRentFrom(String areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }

        public Builder setAreaRentTo(String areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingSearchResponse build() {
            return new BuildingSearchResponse(this);
        }
    }
}
