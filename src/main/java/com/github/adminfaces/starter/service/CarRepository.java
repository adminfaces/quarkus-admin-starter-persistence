package com.github.adminfaces.starter.service;

import com.github.adminfaces.starter.model.Car;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    public Double getTotalPriceByModel(String model) {
        return getEntityManager().createQuery("SELECT SUM(c.price) FROM Car c WHERE upper(c.model) like :model", Double.class)
                .setParameter("model", model).getSingleResult();
    }


}
