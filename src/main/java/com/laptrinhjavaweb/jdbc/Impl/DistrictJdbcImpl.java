package com.laptrinhjavaweb.jdbc.Impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.jdbc.DistrictJdbc;
import com.laptrinhjavaweb.utils.SqlUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictJdbcImpl implements DistrictJdbc {

    private final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    private final String USER = "root";
    private final String PASS = "mysql123";

    @Override
    public  DistrictEntity findById(Integer id){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BuildingEntity buildingModel = new BuildingEntity();
        DistrictEntity districtEntity = new DistrictEntity();
        try {
            conn = SqlUtils.getConnection();
            conn.setAutoCommit(false);
            if (conn != null) {

                StringBuilder sql = new StringBuilder("SELECT d.id ,d.code, d.name FROM district d WHERE id = ? ");

                stmt.setString(1, buildingModel.getDistrictId().toString() );
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.prepareStatement(sql.toString(), stmt.RETURN_GENERATED_KEYS);
                rs = stmt.executeQuery();
                while(rs.next()){
                    districtEntity.setId(rs.getInt("id"));
                    districtEntity.setCode(rs.getString("code"));
                    districtEntity.setName(rs.getString("name"));
                }
                return districtEntity;
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
        return districtEntity;
    }

}


