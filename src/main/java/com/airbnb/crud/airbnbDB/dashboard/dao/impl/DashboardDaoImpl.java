package com.airbnb.crud.airbnbDB.dashboard.dao.impl;

import com.airbnb.crud.airbnbDB.dashboard.dao.IDashboardDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class DashboardDaoImpl implements IDashboardDao {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DashboardDaoImpl( EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Object[]> queryDB(String sql) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        NativeQuery nativeQuery = session.createNativeQuery(sql);
        return nativeQuery.getResultList();
    }
}
