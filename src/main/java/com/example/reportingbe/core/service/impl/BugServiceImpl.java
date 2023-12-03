package com.example.reportingbe.core.service.impl;

import com.example.reportingbe.controller.datamodel.BugDataModel;
import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.core.service.BugService;
import com.example.reportingbe.core.utils.BugConverter;
import com.example.reportingbe.core.utils.MessageCatalog;
import com.example.reportingbe.core.utils.exceptions.BugStatus;
import com.example.reportingbe.core.utils.exceptions.BusinessWebAppException;
import com.example.reportingbe.persistence.dao.BugDao;
import com.example.reportingbe.persistence.dao.UserDao;
import com.example.reportingbe.persistence.entity.Bug;
import com.example.reportingbe.persistence.entity.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugDao bugDao;

    @Autowired
    private BugConverter bugConverter;

    @Override
    public BugDataModel createBug(BugDataModel bugDataModel) {

        Bug newBug = bugConverter.convertInputDataModelToEntity(bugDataModel);

        newBug.setStatus(String.valueOf(BugStatus.NEW));
        try {
            bugDao.createBug(newBug);
        } catch (Exception e) {
            throw new BusinessWebAppException(MessageCatalog.BUG_INVALID_PATTERN, 400);
        }
        return bugConverter.convertEntityToInputDataMode(newBug);
    }

    @Override
    public List<BugDataModel> getAllBugs() {

        return bugDao.getAll()
                .stream()
                .map(bug -> bugConverter.convertEntityToInputDataMode(bug))
                .collect(Collectors.toList());
    }
}
