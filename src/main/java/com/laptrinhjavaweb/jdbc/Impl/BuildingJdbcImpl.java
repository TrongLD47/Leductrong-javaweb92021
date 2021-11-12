package com.laptrinhjavaweb.jdbc.Impl;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.utils.StringUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BuildingJdbcImpl implements BuildingJdbc {
    private final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    private final String USER = "root";
    private final String PASS = "mysql123";

    @Override
    public List<BuildingEntity> findAll(BuildingSearchRequest request){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BuildingEntity> buildings = new ArrayList<>();
		try {
            conn.setAutoCommit(false);
            if (conn != null) {
                StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.districtid, b.managername, " +
                        " b.managerphone, b.createddate, b.floorarea,  b.rentprice, b.servicefee, b.brokeragefee" +
                        " \nFROM building b" +
                        " \nJOIN district d ON d.id = b.districtid");
                StringBuilder joinQuery = new StringBuilder();
                StringBuilder whereQuery = new StringBuilder();

                buildQueryWithJoin(joinQuery, whereQuery, request);
                buildQueryWithoutJoin(whereQuery, request);

                sql.append(joinQuery).append("\nWHERE 1=1 ").append(whereQuery).append("\nGROUP BY b.id");

                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.prepareStatement(sql.toString(), stmt.RETURN_GENERATED_KEYS);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    BuildingEntity buildingModel = new BuildingEntity();
                    buildingModel.setName(rs.getString("name"));
                    buildingModel.setStreet(rs.getString("street"));
                    buildingModel.setWard(rs.getString("ward"));
                    buildingModel.setType(rs.getString("type"));
                    buildingModel.setNumberofbasement(rs.getInt("numberofbasement"));
                    buildingModel.setRentprice(rs.getInt("rentprice"));
                    buildingModel.setFloorarea(rs.getInt("floorarea"));
                    buildingModel.setDistrictCode(rs.getString("code"));
                    buildingModel.setServicefee(rs.getString("servicefee"));
                    buildings.add(buildingModel);
                }
                return buildings;
            }
            conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
                    conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
                    conn.close();
				}
				if (stmt != null) {
                    stmt.close();
				}
				if (rs != null) {
                    rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return new  ArrayList<>();
    }

    private StringBuilder buildQueryWithJoin(StringBuilder joinQuery, StringBuilder whereQuery, BuildingSearchRequest request) {

        if (ValidateUtils.isValid(request.getStaffId())) {

            joinQuery.append(" INNER JOIN assignmentbuilding a ON A.id = a.buildingid ");
            whereQuery.append(" AND b.staffid =  " + request.getStaffId());
        }
        if(request.getBuildingTypes().length > 0){

            joinQuery.append(" INNER JOIN buildingrenttype t ON b.id = t.buildingid  INNER JOIN renttype r ON t.renttypeid = r.id  ");
            whereQuery.append(" AND ( ");

            String buildingTypeSql = Arrays.stream(request.getBuildingTypes()).map(item -> " A.type like '%"+item+"%' ").collect(Collectors.joining(" OR "));

            whereQuery.append(buildingTypeSql + ")");
        }
        return  joinQuery ;
    }

    private StringBuilder buildQueryWithoutJoin(StringBuilder whereQuery, BuildingSearchRequest request) {

        if(!StringUtils.IsNullOrEmpty(request.getStreet())){
            whereQuery.append(" AND b.street like'%" + request.getStreet() + "%' ");
        }
        if(!StringUtils.IsNullOrEmpty(request.getWard())){
            whereQuery.append(" AND b.ward like'%" + request.getWard() + "%' ");
        }
        if(!StringUtils.IsNullOrEmpty(request.getDistrict())){
            whereQuery.append(" AND d.code =  " + request.getDistrict());
        }
        if(request.getNumberOfBasement() != 0){
            whereQuery.append(" AND b.numberofbasement =  " + request.getNumberOfBasement());
        }
        if(request.getBuildingArea() != 0){
            whereQuery.append(" AND b.floorarea like'%" + request.getBuildingArea() + "%' ");
        }
        if (!StringUtils.IsNullOrEmpty(request.getRentPriceFrom().toString())) {
            whereQuery.append(" AND A.rentprice >= " + request.getRentPriceFrom() + "");
        }
        if (!StringUtils.IsNullOrEmpty(request.getRentPriceTo().toString())) {
            whereQuery.append(" AND A.rentprice <= " + request.getRentPriceTo() + "");
        }
//        if(request.getNumberOfBasement() != 0){
//            whereQuery.append(" AND b.servicefee =  " + request.getServiceFee());
//        }
//        if(request.getBrokerAgeFee() != 0){
//            whereQuery.append(" AND b.brokeragefee =  " + request.getBrokerAgeFee());
//        }
        if (request.getAreaRentFrom() != 0 || (request.getAreaRentTo() != 0 )) {
            whereQuery.append(" AND EXISTS (SELECT * From rentarea R WHERE (R.buildingid = A.id");
            if (request.getAreaRentFrom() != null) {
                whereQuery.append(" AND R.value >= " + request.getAreaRentFrom() + "");
            }
            if (request.getAreaRentTo() != null) {
                whereQuery.append(" AND R.value >= " + request.getAreaRentTo() + "");
            }
            whereQuery.append("))");
        }
        return whereQuery;
    }

}
