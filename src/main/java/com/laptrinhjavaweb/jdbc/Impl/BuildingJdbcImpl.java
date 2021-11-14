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
                StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.districtid, " +
                        "  b.createddate, b.floorarea,  b.rentprice, b.servicefee, b.brokeragefee" +
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
                    buildingModel.setDistrictId(rs.getInt("districtid"));
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

    private void buildQueryWithJoin(StringBuilder joinQuery, StringBuilder whereQuery, BuildingSearchRequest request) {

        if (ValidateUtils.isValid(request.getStaffId())) {

            joinQuery.append(" INNER JOIN assignmentbuilding a ON b.id = a.buildingid ");
            whereQuery.append(" AND b.staffid =  " + request.getStaffId());
        }
        if(request.getBuildingTypes().length > 0){

            joinQuery.append(" INNER JOIN buildingrenttype t ON b.id = t.buildingid  INNER JOIN renttype r ON t.renttypeid = r.id  ");
            whereQuery.append(" AND ( ");

            String buildingTypeSql = Arrays.stream(request.getBuildingTypes()).map(item -> " A.type like '%"+item+"%' ").collect(Collectors.joining(" OR "));

            whereQuery.append(buildingTypeSql + ")");
        }

        /*if (request.getAreaRentFrom() != 0 || (request.getAreaRentTo() != 0 )) {
            joinQuery.append(" INNER JOIN rentarea e ON b.id = e.buildingid ");
            whereQuery.append(" AND EXISTS (");
            if (request.getAreaRentFrom() != null) {
                whereQuery.append(" e.value >= " + request.getAreaRentFrom() + "");

            if (request.getAreaRentTo() == null && request.getAreaRentTo() != null) {
                    whereQuery.append(" e.value >= " + request.getAreaRentTo() + "");
                }
            }
            if (request.getAreaRentFrom() != null && request.getAreaRentTo() != null) {
                whereQuery.append(" AND e.value >= " + request.getAreaRentTo() + "");
            }
            whereQuery.append(")");
        }*/
    }

    private void buildQueryWithoutJoin(StringBuilder whereQuery, BuildingSearchRequest request) {

        if(ValidateUtils.isValid(request.getStreet())){
            whereQuery.append(" AND b.street like'%" + request.getStreet() + "%' ");
        }
        if(ValidateUtils.isValid(request.getWard())){
            whereQuery.append(" AND b.ward like'%" + request.getWard() + "%' ");
        }
        if(ValidateUtils.isValid(request.getDistrict())){
            whereQuery.append(" AND d.code =  " + request.getDistrict());
        }
        if(request.getNumberOfBasement() != 0){
            whereQuery.append(" AND b.numberofbasement =  " + request.getNumberOfBasement());
        }
        if(request.getBuildingArea() != 0){
            whereQuery.append(" AND b.floorarea like'%" + request.getBuildingArea() + "%' ");
        }
        if (ValidateUtils.isValid(request.getRentPriceFrom().toString())) {
            whereQuery.append(" AND b.rentprice >= " + request.getRentPriceFrom() + "");
        }
        if (ValidateUtils.isValid(request.getRentPriceTo().toString())) {
            whereQuery.append(" AND b.rentprice <= " + request.getRentPriceTo() + "");
        }
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
//        if(request.getNumberOfBasement() != 0){
//            whereQuery.append(" AND b.servicefee =  " + request.getServiceFee());
//        }
//        if(request.getBrokerAgeFee() != 0){
//            whereQuery.append(" AND b.brokeragefee =  " + request.getBrokerAgeFee());
//        }

    }

}
