package com.eik.service;

import com.eik.domain.SystemType;
import com.eik.repository.SystemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbSystemService {

    @Autowired
    private SystemDao systemDao;

    public List<SystemType> getAllSystems(){return systemDao.findAll();}

    public SystemType getSystemById(final Long systemId){
        return systemDao.findBySystemId(systemId).orElse(null);
    }

    public SystemType saveSystem(final SystemType systemType){return systemDao.save(systemType);}

    public void deleteSystem(final Long systemId){systemDao.deleteBySystemId(systemId);}

}
