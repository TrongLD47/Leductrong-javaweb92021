package com.laptrinhjavaweb.jdbc;

import com.laptrinhjavaweb.entity.DistrictEntity;

import java.util.List;

public interface DistrictJdbc {
    DistrictEntity findById(Integer id);
}
