package com.laptrinhjavaweb.jdbc.Impl;

import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.utils.StringUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class BuildingJdbcImpl implements BuildingJdbc {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<BuildingEntity> findAll(BuildingSearchResponse buildingSearch){

        StringBuilder sqlGetAll = new StringBuilder("Select * from building A  WHERE 1=1");
        if (StringUtils.IsNullOrEmpty(buildingSearch.getStaffId())) {
            sqlGetAll.append(" INNER JOIN assignmentbuilding assignmentbuilding ON A.id = assignmentbuilding.buildingid ");
        }
        if (StringUtils.IsNullOrEmpty(buildingSearch.getCostRentFrom())) {
            sqlGetAll.append(" AND A.rentprice >= " + buildingSearch.getCostRentFrom() + "");
        }
        if (StringUtils.IsNullOrEmpty(buildingSearch.getRentPriceTo())) {
            sqlGetAll.append(" AND A.rentprice <= " + buildingSearch.getRentPriceTo() + "");
        }
        if (StringUtils.IsNullOrEmpty(buildingSearch.getAreaRentFrom()) || StringUtils.IsNullOrEmpty(buildingSearch.getAreaRentTo())) {
            sqlGetAll.append(" AND EXISTS (SELECT * From rentarea R WHERE (R.buildingid = A.id");
            if (buildingSearch.getAreaRentFrom() != null) {
                sqlGetAll.append(" AND R.value >= " + buildingSearch.getAreaRentFrom() + "");
            }
            if (buildingSearch.getAreaRentTo() != null) {
                sqlGetAll.append(" AND R.value >= " + buildingSearch.getAreaRentTo() + "");
        }
            sqlGetAll.append("))");
        }
        if (StringUtils.IsNullOrEmpty(buildingSearch.getStaffId())) {
            sqlGetAll.append(" AND assignmentbuilding.staffid =  " + buildingSearch.getStaffId());
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getNumberOfBasement())){
            sqlGetAll.append(" AND A.numberofbasement =  " + buildingSearch.getNumberOfBasement());
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getStreet())){
            sqlGetAll.append(" AND A.street like'%" + buildingSearch.getStreet() + "%' ");
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getFloorArea())){
            sqlGetAll.append(" AND A.street like'%" + buildingSearch.getFloorArea() + "%' ");
        }
        if(StringUtils.IsNullOrEmpty(buildingSearch.getWard())){
            sqlGetAll.append(" AND A.ward like'%" + buildingSearch.getWard() + "%' ");
        }
        Query query = entityManager.createNativeQuery(sqlGetAll.toString(), BuildingEntity.class);
        return query.getResultList();
    }

}
