package ro.siit.jpa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ro.siit.jpa.entity.Make;
import ro.siit.jpa.listener.LocalEntityManagerFactory;


import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBMakesStore implements ro.siit.jpa.service.MakeStore {

    private final EntityManager entityManager;
    private Logger LOGGER = LogManager.getLogger(DBMakesStore.class);
    public DBMakesStore(){
        entityManager = LocalEntityManagerFactory.createEntityManager();
    }


    @Override
    public Make getMake(UUID makeId) {
        return entityManager.find(Make.class, makeId);
    }

    @Override
    public void addMake(Make make) {
        entityManager.getTransaction().begin();
        entityManager.persist(make);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateMake(UUID makeId, Make updatedMake) {

    }

    @Override
    public void deleteMake(UUID makeId) {

    }

    @Override
    public List<Make> getMakes() {
        return entityManager
                .createQuery("select m from Make m")
                .getResultList();
    }
}
