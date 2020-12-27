package com.github.adminfaces.starter.bean;

import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.persistence.service.Service;
import com.github.adminfaces.starter.model.Car;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.stream.IntStream;

@ApplicationScoped
public class InitAppMB implements Serializable {

    @Inject
    @Service
    private CrudService<Car,Integer> crudService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        IntStream.rangeClosed(1, 50)
                .forEach(i -> create(i));
    }

    private void create(int i) {
        crudService.insert(new Car().model("model " + i).name("name" + i).price(Double.valueOf(i)));
    }

}
