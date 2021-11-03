package com.laptrinhjavaweb.jdbc.Impl;

import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.utils.StringUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class BuildingJdbcImpl implements BuildingJdbc {

    @Override
    public List<BuildingEntity> findAll(BuildingSearchResponse buildingSearch){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BuildingEntity> buildings = new ArrayList<>();
		try {
            conn.setAutoCommit(false);
            if (conn != null) {
                StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
                if (StringUtils.IsNullOrEmpty(buildingSearch.getStaffId())) {
                    sql.append(" INNER JOIN assignmentstaff assignmentstaff ON A.id = assignmentstaff.buildingid ");
                }
                if (StringUtils.IsNullOrEmpty(buildingSearch.getCostRentFrom())) {
                    sql.append(" AND A.rentprice >= " + buildingSearch.getCostRentFrom() + "");
                }
                if (StringUtils.IsNullOrEmpty(buildingSearch.getRentPriceTo())) {
                    sql.append(" AND A.rentprice <= " + buildingSearch.getRentPriceTo() + "");
                }
                if (StringUtils.IsNullOrEmpty(buildingSearch.getAreaRentFrom()) || StringUtils.IsNullOrEmpty(buildingSearch.getAreaRentTo())) {
                    sql.append(" AND EXISTS (SELECT * From rentarea R WHERE (R.buildingid = A.id");
                    if (buildingSearch.getAreaRentFrom() != null) {
                        sql.append(" AND R.value >= " + buildingSearch.getAreaRentFrom() + "");
                    }
                    if (buildingSearch.getAreaRentTo() != null) {
                        sql.append(" AND R.value >= " + buildingSearch.getAreaRentTo() + "");
                    }
                    sql.append("))");
                }
                if(StringUtils.IsNullOrEmpty(buildingSearch.getNumberOfBasement())){
                    sql.append(" AND A.numberofbasement =  " + buildingSearch.getNumberOfBasement());
                }
                if(StringUtils.IsNullOrEmpty(buildingSearch.getStreet())){
                    sql.append(" AND A.street like'%" + buildingSearch.getStreet() + "%' ");
                }
                if(StringUtils.IsNullOrEmpty(buildingSearch.getFloorArea())){
                    sql.append(" AND A.floorarea like'%" + buildingSearch.getFloorArea() + "%' ");
                }
                if(StringUtils.IsNullOrEmpty(buildingSearch.getWard())){
                    sql.append(" AND A.ward like'%" + buildingSearch.getWard() + "%' ");
                }
                stmt = conn.prepareStatement(sql.toString(), stmt.RETURN_GENERATED_KEYS);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    BuildingEntity buildingModel = new BuildingEntity();
                    buildingModel.setName(rs.getString("name"));
                    buildingModel.setStreet(rs.getString("street"));
                    buildingModel.setWard(rs.getString("ward"));
                    buildingModel.setType(rs.getString("type"));
                    buildingModel.setValue(rs.getInt("value"));
                    buildingModel.setNumberofbasement(rs.getInt("numberofbasement"));
                    buildingModel.setRentprice(rs.getInt("rentprice"));
                    buildingModel.setFloorarea(rs.getInt("floorarea"));

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

}
