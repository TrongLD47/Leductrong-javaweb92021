package com.laptrinhjavaweb.jdbc.Impl;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.utils.StringUtils;
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
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearch){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BuildingEntity> buildings = new ArrayList<>();
		try {
            conn.setAutoCommit(false);
            if (conn != null) {
                StringBuilder sql = new StringBuilder("SELECT A.name, A.street, A.ward, D.code, A.numberofbasement, A.rentprice, A.floorarea, A.servicefee FROM building A");
                sql.append(" INNER JOIN district D ON A.districtid = D.id ");
                if (buildingSearch.getStaffId() != 0) {
                    sql.append(" INNER JOIN assignmentbuilding S ON A.id = S.buildingid ");
                }
                if(StringUtils.IsNullOrEmpty(buildingSearch.getBuildingTypes().toString() )){
                    sql.append(" INNER JOIN buildingrenttype B ON A.id = B.buildingid  INNER JOIN renttype C ON B.renttypeid = C.id  ");
                }

                sql.append(" WHERE 1 = 1 ");
                String sqlSeacrhField = buildingSearchField(buildingSearch);
                sql.append(sqlSeacrhField);

                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.prepareStatement(sql.toString(), stmt.RETURN_GENERATED_KEYS);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    BuildingEntity buildingModel = new BuildingEntity();
                    buildingModel.setName(rs.getString("name"));
                    buildingModel.setStreet(rs.getString("street"));
                    buildingModel.setWard(rs.getString("ward"));
                   /* buildingModel.setType(rs.getString("type"));*/
                    buildingModel.setNumberofbasement(rs.getInt("numberofbasement"));
                    buildingModel.setRentprice(rs.getInt("rentprice"));
                    buildingModel.setFloorarea(rs.getInt("floorarea"));
                    buildingModel.setDistrictCode(rs.getString("code"));
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

    private String buildingSearchField(BuildingSearchRequest buildingSearch){
        StringBuilder sql = new StringBuilder("");
        if (StringUtils.IsNullOrEmpty(buildingSearch.getRentPriceFrom().toString())) {
            sql.append(" AND A.rentprice >= " + buildingSearch.getRentPriceFrom() + "");
        }
        if (StringUtils.IsNullOrEmpty(buildingSearch.getRentPriceTo().toString())) {
            sql.append(" AND A.rentprice <= " + buildingSearch.getRentPriceTo() + "");
        }
        if (buildingSearch.getAreaRentFrom() != 0 || (buildingSearch.getAreaRentTo() != 0 )) {
            sql.append(" AND EXISTS (SELECT * From rentarea R WHERE (R.buildingid = A.id");
            if (buildingSearch.getAreaRentFrom() != null) {
                sql.append(" AND R.value >= " + buildingSearch.getAreaRentFrom() + "");
            }
            if (buildingSearch.getAreaRentTo() != null) {
                sql.append(" AND R.value >= " + buildingSearch.getAreaRentTo() + "");
            }
            sql.append("))");
        }
        if(buildingSearch.getBuildingTypes().length > 0){
            sql.append(" AND ( ");

            String buildingTypeSql = Arrays.stream(buildingSearch.getBuildingTypes()).map(item -> " A.type like '%"+item+"%' ").collect(Collectors.joining(" OR "));

            sql.append(buildingTypeSql + ")");
        }

        if(StringUtils.IsNullOrEmpty(buildingSearch.getStreet())){
            sql.append(" AND A.street like'%" + buildingSearch.getStreet() + "%' ");
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getWard())){
            sql.append(" AND A.ward like'%" + buildingSearch.getWard() + "%' ");
        }
        if(buildingSearch.getNumberOfBasement() != 0){
            sql.append(" AND A.numberofbasement =  " + buildingSearch.getNumberOfBasement());
        }
        if(buildingSearch.getBuildingArea() != 0){
            sql.append(" AND A.floorarea like'%" + buildingSearch.getBuildingArea() + "%' ");
        }
        if(buildingSearch.getStaffId() != 0){
            sql.append(" AND S.staffid = " + buildingSearch.getStaffId() + " ");
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getDistrict())){
            sql.append(" AND D.code  = "+ buildingSearch.getDistrict() + " ");
        }

        sql.append(" GROUP BY A.id ");

        return sql.toString();
    }

}
