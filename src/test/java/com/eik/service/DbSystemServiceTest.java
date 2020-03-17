package com.eik.service;

import com.eik.domain.SystemType;
import com.eik.repository.SystemDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbSystemServiceTest {

    private SystemType systemType1;
    private SystemType systemType2;

    @Autowired
    private DbSystemService dbSystemService;

    @Autowired
    private SystemDao systemDao;

    @Before
    public void before(){
        systemType1 = new SystemType("ŁÓDKA", "dobrze pływa po www", "CSS, HTML", "Bolemir");
        systemType2 = new SystemType("DOMEK", "pisze w c", "C++", "Raczykowski");
    }

    @Test
    public void testGetAllSystems(){
        //Given
        systemDao.save(systemType1);
        systemDao.save(systemType2);
        //When
        List<SystemType> test = dbSystemService.getAllSystems();
        //Then
        assertEquals(2, test.size());
        //CleanUp
        systemDao.deleteBySystemId(systemType1.getSystemId());
        systemDao.deleteBySystemId(systemType2.getSystemId());
    }

    @Test
    public void testGetSystemById(){
        //Given
        systemDao.save(systemType1);
        systemDao.save(systemType2);
        Long id = systemType2.getSystemId();
        //When
        SystemType test = dbSystemService.getSystemById(id);
        //Then
        assertEquals("DOMEK", test.getNameOfTheSystem());
        //CleanUp
        systemDao.deleteBySystemId(systemType1.getSystemId());
        systemDao.deleteBySystemId(systemType2.getSystemId());
    }

    @Test
    public void testSaveSystem(){
        //When
        dbSystemService.saveSystem(systemType1);
        dbSystemService.saveSystem(systemType2);
        //Then
        assertEquals(2, dbSystemService.getAllSystems().size());
        //CleanUp
        systemDao.deleteBySystemId(systemType1.getSystemId());
        systemDao.deleteBySystemId(systemType2.getSystemId());
    }

    @Test
    public void testDeleteAgreements(){
        //Given
        systemDao.save(systemType1);
        systemDao.save(systemType2);
        //When
        dbSystemService.deleteSystem(systemType1.getSystemId());
        dbSystemService.deleteSystem(systemType2.getSystemId());
        //Then
        assertEquals(0, dbSystemService.getAllSystems().size());
    }
}
