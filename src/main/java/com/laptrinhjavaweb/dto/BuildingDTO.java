package com.laptrinhjavaweb.dto;

public class BuildingDTO  extends AbstractDTO{

        private String name;
        private String numberOfBasement;
        private String buildingArea;
        private String district;
        private String ward;
        private String street;
        private String structure;
        private Integer rentprice;
        private String costdescription;
        private String serviceCost;
        private String carCost;
        private String motorbikeCost;
        private String overtimeCost;
        private String electricityCost;
        private String deposit	;
        private String payMent;
        private String timeRent;
        private String timeDecorator	;
        private String managerName;
        private String managerPhone;
        private String[] buildingTypes= new String[] {};
        private String rentpriceFrom;
        private String rentpriceTo;
        private String areaRentTo;
        private String areaRentFrom;
        private String staffId;
        private String areaRent; //areaRent = "100,200,300";
        private String address;

        public String getAddress() {
        return address;
    }
        public void setAddress(String address) {
        this.address = address;
    }

        public String getAreaRent() {
            return areaRent;
        }
        public String getBuildingArea() {
        return buildingArea;
    }
        public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }
        public String getRentpriceFrom() {
        return rentpriceFrom;
    }
        public void setRentpriceFrom(String rentpriceFrom) {
        this.rentpriceFrom = rentpriceFrom;
    }
        public String getRentpriceTo() {
        return rentpriceTo;
    }
        public void setRentpriceTo(String rentpriceTo) {
        this.rentpriceTo = rentpriceTo;
    }
        public void setAreaRent(String areaRent) {
            this.areaRent = areaRent;
        }
        public String[] getBuildingTypes() {
            return buildingTypes;
        }
        public void setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
        }
        public String getCostRentFrom() {
            return rentpriceFrom;
        }
        public void setCostRentFrom(String costRentFrom) {
            this.rentpriceFrom = costRentFrom;
        }
        public String getCostRentTo() {
            return rentpriceTo;
        }
        public void setCostRentTo(String costRentTo) {
            this.rentpriceTo = costRentTo;
        }
        public String getAreaRentTo() {
            return areaRentTo;
        }
        public void setAreaRentTo(String areaRentTo) {
            this.areaRentTo = areaRentTo;
        }
        public String getAreaRentFrom() {
            return areaRentFrom;
        }
        public void setAreaRentFrom(String areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDistrict() {
            return district;
        }
        public String getNumberOfBasement() {
            return numberOfBasement;
        }
        public void setNumberOfBasement(String numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
        }
        public void setDistrict(String district) {
            this.district = district;
        }
        public String getWard() {
            return ward;
        }
        public void setWard(String ward) {
            this.ward = ward;
        }
        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String getStructure() {
            return structure;
        }
        public void setStructure(String structure) {
            this.structure = structure;
        }
        public String getCostdescription() {
            return costdescription;
        }
        public void setCostdescription(String costdescription) {
            this.costdescription = costdescription;
        }
        public String getServiceCost() {
            return serviceCost;
        }
        public void setServiceCost(String serviceCost) {
            this.serviceCost = serviceCost;
        }
        public String getCarCost() {
            return carCost;
        }
        public void setCarCost(String carCost) {
            this.carCost = carCost;
        }
        public String getMotorbikeCost() {
            return motorbikeCost;
        }
        public void setMotorbikeCost(String motorbikeCost) {
            this.motorbikeCost = motorbikeCost;
        }
        public String getOvertimeCost() {
            return overtimeCost;
        }
        public void setOvertimeCost(String overtimeCost) {
            this.overtimeCost = overtimeCost;
        }
        public String getElectricityCost() {
            return electricityCost;
        }
        public void setElectricityCost(String electricityCost) {
            this.electricityCost = electricityCost;
        }
        public String getDeposit() {
            return deposit;
        }
        public void setDeposit(String deposit) {
            this.deposit = deposit;
        }
        public String getPayMent() {
            return payMent;
        }
        public void setPayMent(String payMent) {
            this.payMent = payMent;
        }
        public String getTimeRent() {
            return timeRent;
        }
        public void setTimeRent(String timeRent) {
            this.timeRent = timeRent;
        }
        public Integer getRentprice() {
        return rentprice;
    }
        public void setRentprice(Integer rentprice) {
        this.rentprice = rentprice;
    }
        public String getTimeDecorator() {
            return timeDecorator;
        }
        public void setTimeDecorator(String timeDecorator) {
            this.timeDecorator = timeDecorator;
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
        public String getStaffId() {
            return staffId;
        }
        public void setStaffId(String staffId) {
            this.staffId = staffId;
        }


    }
