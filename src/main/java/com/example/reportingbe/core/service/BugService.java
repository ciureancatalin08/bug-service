package com.example.reportingbe.core.service;

import com.example.reportingbe.controller.datamodel.BugDataModel;

import java.util.List;

public interface BugService {

    BugDataModel createBug(BugDataModel bugDataModel);

    List<BugDataModel> getAllBugs();

}
