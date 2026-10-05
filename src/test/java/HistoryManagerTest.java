import alim.dev.history.HistoryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HistoryManagerTest {
    private final HistoryManager history = new HistoryManager();

@Test
    public void historyStoriesOperation(){
        history.addToHistory("5.0 + 5.0");
        assertEquals(1, history.getSize());
    }

@Test
    public void historyStoriesWithTwoOperations(){
        history.addToHistory("7.0 / 2.0");
        history.addToHistory("62.0 * 2.0");
        assertEquals(2, history.getSize());
}

@Test
    public void historyStoriesNotEquals(){
        history.addToHistory("8.2 + 3.0");
        assertNotEquals(2, history.getHistory().size());
}

@Test
    public void getHistoryOperation(){
        history.addToHistory("5.5 + 5.0");
        assertEquals("5.5 + 5.0", history.getHistory().get(0));

}

@Test
    public void getLastInput(){
        history.addToHistory("9.0 / 2.0");
        history.addToHistory("3.0 * 2.0");
        assertEquals("3.0 * 2.0", history.getLastExpression());
}

@Test
    public void clearAllHistory(){
    history.addToHistory("10.0 + 4.2");
    history.addToHistory("17.5 / 2.0");
    history.clearAllHistory();
    assertTrue(history.getHistory().isEmpty());
}

@Test
    public void maxOperationsHistorySizeTest(){
    for(int i = 0; i < 11; i++){
        history.addToHistory("1 + " + i );

    }
    assertTrue(history.getSize() == 10);

}

@Test
    public void maxResultHistorySizeTest(){
    for(int i = 0; i < 11; i++){
        history.addHistoryResultToHistory( String.valueOf(i) );

    }
    assertTrue(history.getHistoryOfResult().size() == 10);



}





}
