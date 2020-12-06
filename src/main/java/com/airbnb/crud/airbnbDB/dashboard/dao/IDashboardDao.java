package com.airbnb.crud.airbnbDB.dashboard.dao;
import java.util.List;
public interface IDashboardDao {
    List<Object[]> queryDB(String sql);
}
