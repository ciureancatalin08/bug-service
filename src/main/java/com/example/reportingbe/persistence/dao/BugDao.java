package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.controller.datamodel.BugDataModel;
import com.example.reportingbe.persistence.entity.Bug;

import java.util.List;

public interface BugDao {

    Bug createBug(Bug bug);

    List<Bug> getAll();

    void updateBug(Bug newBug);

    Bug getById(long id);

}
