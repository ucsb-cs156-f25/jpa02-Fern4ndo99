package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    
    // Case 1
    @Test
    public void testEquals_sameObject() {
        Team t1 = Developer.getTeam();
        assertEquals(true, t1.equals(t1));
    }
    
    // Case 2: different class
    @Test
    public void testEquals_differentClass() {
        Team t1 = Developer.getTeam();
        String notTeam = "Not a team";
        assertEquals(false, t1.equals(notTeam));
    }
    // Case 3
    @Test
    public void testEquals_sameNameAndMembers() {
        Team t1 = Developer.getTeam();
        Team t2 = Developer.getTeam();
        assertEquals(true, t1.equals(t2));
    }

    @Test
    public void testEquals_sameNameDifferentMembers() {
        Team t1 = Developer.getTeam();
        Team t2 = new Team("f25-14");
        t2.addMember("SomeoneElse");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void testEquals_differentNameSameMembers() {
        Team t1 = Developer.getTeam();
        Team t2 = new Team("different-team");
        t2.setMembers(t1.getMembers());
        assertEquals(false, t1.equals(t2));
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void testHashCode_equalObjects() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void testHashCode_specificValue() {
        Team t = new Team("foo");
        t.addMember("bar");


        int result = t.hashCode();
        System.out.println("Actual hashCode = " + result);

        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }

}
