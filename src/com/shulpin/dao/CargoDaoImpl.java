package com.shulpin.dao;

import com.shulpin.model.Cargo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("cargoDao")
public class CargoDaoImpl extends AbstractDao implements CargoDao {


    public void saveCargo(Cargo cargo) {
        persist(cargo);
    }

    @SuppressWarnings("unchecked")
    public List<Cargo> findAllCargo() {
        Criteria criteria = getSession().createCriteria(Cargo.class);
        return (List<Cargo>) criteria.list();
    }

    public void deleteCargoById(Long id) {

        Query query = getSession().createSQLQuery("delete from Cargo where id = :id");
        query.setLong("id", id);
        query.executeUpdate();

    }

    public Cargo findById(Long id) {
        Criteria criteria = getSession().createCriteria(Cargo.class);
        criteria.add(Restrictions.eq("id",id));
        return (Cargo) criteria.uniqueResult();
    }

    public void updateCargo(Cargo cargo) {
        getSession().update(cargo);
    }
}
