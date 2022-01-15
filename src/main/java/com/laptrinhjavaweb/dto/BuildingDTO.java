package com.laptrinhjavaweb.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {
	private String name;
	private Integer numberOfBasement;
	private Integer buildingArea;
	private String district;
	private String ward;
	private String street;
	private String structure;
	private Integer costRent;	
	private Integer costDescription;
	private Integer serviceCost;
	private Integer carCost;
	private Integer motorbikeCost;
	private Integer overtimeCost;
	private Integer electricityCost;
	private Integer deposit;
	private Integer payment;
	private Integer timeRent;
	private String timeDecorator;
	private String managerName;
	private String managerPhone;
	private String type;
	private String[] buildingTypes = new String[] {};
	private String rentPriceFrom;
	private String rentPriceTo;
	private String areaRentFrom;
	private String areaRentTo;
	private Integer staffId;
	private Integer rentArea;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}
	*/
	public String getDistrict() {
		return district;
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
	public Integer getCostRent() {
		return costRent;
	}
	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}
	public Integer getCostDescription() {
		return costDescription;
	}
	public void setCostDescription(Integer costDescription) {
		this.costDescription = costDescription;
	}
	public Integer getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(Integer serviceCost) {
		this.serviceCost = serviceCost;
	}
	public Integer getCarCost() {
		return carCost;
	}
	public void setCarCost(Integer carCost) {
		this.carCost = carCost;
	}
	public Integer getMotorbikeCost() {
		return motorbikeCost;
	}
	public void setMotorbikeCost(Integer motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}
	public Integer getOvertimeCost() {
		return overtimeCost;
	}
	public void setOvertimeCost(Integer overtimeCost) {
		this.overtimeCost = overtimeCost;
	}
	public Integer getElectricityCost() {
		return electricityCost;
	}
	public void setElectricityCost(Integer electricityCost) {
		this.electricityCost = electricityCost;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public Integer getTimeRent() {
		return timeRent;
	}
	public void setTimeRent(Integer timeRent) {
		this.timeRent = timeRent;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
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
	public void setCostRentFrom(String costRentFrom) {
		this.rentPriceFrom = costRentFrom;
	}
	public String getCostRentTo() {
		return rentPriceTo;
	}
	public void setCostRentTo(String costRentTo) {
		this.rentPriceTo = costRentTo;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
	public Integer getRentArea() {
		return rentArea;
	}
	public void setRentArea(Integer rentArea) {
		this.rentArea = rentArea;
	}
	public String getRentAreaFrom() {
		return areaRentFrom;
	}
	public void setRentAreaFrom(String rentAreaFrom) {
		this.areaRentFrom = rentAreaFrom;
	}
	public String getRentAreaTo() {
		return areaRentTo;
	}
	public void setRentAreaTo(String rentAreaTo) {
		this.areaRentTo = rentAreaTo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}
