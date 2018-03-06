package course2.week.one;

import org.junit.Test;

public class DiceRollingTest {
    @Test
    public void testDiceRolling(){
    DiceRolling dr = new DiceRolling();
    dr.simpleSimulate(10000);
    }
    @Test
    public void testSimulate(){
        DiceRolling dr = new DiceRolling();
        dr.simulate(10);
    }
}
