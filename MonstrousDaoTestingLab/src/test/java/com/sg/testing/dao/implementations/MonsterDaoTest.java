package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoC;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoD;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoE;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoF;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author drive
 */
public class MonsterDaoTest {
    
    private MonsterDao subjectImpl;
    
    public MonsterDaoTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MonsterDao[] daoChoices = {
            new AGoodMonsterDao(),
            new BadMonsterDaoA(),
            new BadMonsterDaoB(),
            new BadMonsterDaoC(),
            new BadMonsterDaoD(),
            new BadMonsterDaoE(),
            new BadMonsterDaoF(),
        };
        subjectImpl = daoChoices[6];
    }
    
    @Test
    public void testAddThenGetSameMonster() {
        Monster testMonster = new Monster();
        testMonster.setName("Dracula");
        testMonster.setType(MonsterType.VAMPIRE);
        testMonster.setFavoriteFood("Hemoglobin");
        testMonster.setPeopleEaten(0);
        
        Monster retrievedMonster = subjectImpl.addMonster(0, testMonster);
        assertNull(
            retrievedMonster,
            "At this point, there should be no monsters yet"
        );
        
        retrievedMonster = subjectImpl.getMonster(0);
        assertEquals(
            testMonster, 
            retrievedMonster, 
            "The monster retrieved from the DAO should be the same as the one "
            + "added in to the DAO"
        );
    }
    
    @Test
    public void testAddThenRemoveSameMonster() {
        Monster dracula = new Monster("Dracula", MonsterType.VAMPIRE, 0, "Hemoglobin");
        assertNull(
            subjectImpl.addMonster(0, dracula), 
            "There should be no monsters yet"
        );
        
        assertEquals(
            dracula,
            subjectImpl.removeMonster(0),
            "The monster removed should be dracula"
        );
        
        assertNull(
            subjectImpl.removeMonster(0),
            "The monster should already be removed"
        );
    }
    
    @Test
    public void testGetAndRemoveOnEmpty() {
        assertNull(
            subjectImpl.getMonster(0),
            "There should be no monsters acquired since the DAO is empty"
        );
        
        assertNull(
            subjectImpl.removeMonster(0),
            "There should be no monsters removed since the DAO is empty"
        );
    }

    @Test
    public void testAddThenGetAll() {
        Monster dracula = new Monster("Dracula", MonsterType.VAMPIRE, 0, "Hemoglobin");
        Monster godzilla = new Monster("Godzilla", MonsterType.LIZARDMAN, 0, "Nuclear bombs");
        
        assertNull(
            subjectImpl.addMonster(0, dracula),
            "There should be no monsters with an id of 0 yet"
        );
        
        assertNull(
            subjectImpl.addMonster(1, godzilla),
            "There should be no monsters with an id of 1 yet"
        );
        
        List<Monster> retrievedMonsters = subjectImpl.getAllMonsters();
        assertEquals(2, retrievedMonsters.size(), "There should be two monsters");
        
        assertTrue(retrievedMonsters.contains(dracula), "Dracula should be in the list");
        assertTrue(retrievedMonsters.contains(godzilla), "Godzilla should be in the list");
    }
    
    @Test
    public void testUpdateOnEmpty() {
        Monster dracula = new Monster("Dracula", MonsterType.VAMPIRE, 0, "Hemoglobin");
        
        subjectImpl.updateMonster(0, dracula);
        
        assertNull(
            subjectImpl.getMonster(0),
            "There were no monsters at the time of updating, so this should be null"
        );
    }
    
    @Test
    public void testAddThenGetTwiceOnSameMonster() {
        Monster dracula = new Monster("Dracula", MonsterType.VAMPIRE, 0, "Hemoglobin");
        
        assertNull(
            subjectImpl.addMonster(0, dracula),
            "There should be no monsters in the DAO yet"
        );
        
        assertEquals(
            dracula,
            subjectImpl.getMonster(0),
            "Dracula should be retrievable from the DAO after being added"
        );
        
        assertEquals(
            dracula,
            subjectImpl.getMonster(0),
            "Dracula should still be retrievable from the DAO after geing retrieved"
        );
    }
}
