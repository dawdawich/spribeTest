package wordCounter;

import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {



    @Test
    public void getInstanceThreadTest() throws Exception {

        new Thread(() -> {
            Counter.getInstance().addWord("Pipe");
            Counter.getInstance().addWord("Wipe");
            Counter.getInstance().addWord("Xipe");
            Counter.getInstance().addWord("HiPe");
            Counter.getInstance().addWord("VIpe");
            Counter.getInstance().addWord("Pipe");
            Counter.getInstance().addWord("Vipe");
        }).start();

        new Thread(() -> {
            Counter.getInstance().addWord("lipe");
            Counter.getInstance().addWord("lipe");
            Counter.getInstance().addWord("lipe");
            Counter.getInstance().addWord("liPe");
            Counter.getInstance().addWord("lIpe");
            Counter.getInstance().addWord("lipe");
            Counter.getInstance().addWord("lipe");
        }).start();

        new Thread(() -> {
            Counter.getInstance().addWord("Sipe");
            Counter.getInstance().addWord("Sipe");
            Counter.getInstance().addWord("Sipe");
            Counter.getInstance().addWord("SiPe");
            Counter.getInstance().addWord("SIpe");
            Counter.getInstance().addWord("Sipe");
            Counter.getInstance().addWord("Sipe");
        }).start();


    }

    @Test
    public void addWordsTest()
    {
        Counter.getInstance().addWord("Pipe");
        Counter.getInstance().addWord("Wipe");
        Counter.getInstance().addWord("Xipe");
        Counter.getInstance().addWord("HiPe");
        Counter.getInstance().addWord("VIpe");
        Counter.getInstance().addWord("Pipe");
        Counter.getInstance().addWord("Vipe");

        assertEquals(Counter.getInstance().getWordCount("VIPE"), 2);

    }

}