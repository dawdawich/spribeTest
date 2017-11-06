package findOponent;

import org.junit.Test;

import static org.junit.Assert.*;

public class GamerQueueTest {

    Gamer gamer1 = new Gamer("Vova", 56.6);
    Gamer gamer2 = new Gamer("Vova", 169.3);
    Gamer gamer3 = new Gamer("Vova", 178.2);
    Gamer gamer4 = new Gamer("Vova", 365.9);
    Gamer gamer5 = new Gamer("Vova", 547.3);
    Gamer gamer6 = new Gamer("Vova", 214.3);
    Gamer gamer7 = new Gamer("Vova", 321.8);
    Gamer gamer8 = new Gamer("Vova", 96.5);
    Gamer gamer9 = new Gamer("Vova", 108);

    Gamer[] gamers1 = {gamer1, gamer2, gamer3};
    Gamer[] gamers2 = {gamer4, gamer5, gamer6};
    Gamer[] gamers3 = {gamer7, gamer8, gamer9};

    @Test
    public void addGamer() throws Exception {

        new Thread(() -> {
            for (Gamer aGamers1 : gamers1) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }
        }).start();

        new Thread(() -> {
            for (Gamer aGamers1 : gamers2) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }
        }).start();

        new Thread(() -> {
            for (Gamer aGamers1 : gamers3) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }
        }).start();

    }

    @Test
    public void placeOpponents() throws Exception {

            for (Gamer aGamers1 : gamers1) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }

            for (Gamer aGamers1 : gamers2) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }

            for (Gamer aGamers1 : gamers3) {
                GamerQueue.getInstance().addGamer(aGamers1);
            }

        GamerQueue.getInstance().placeOpponents();

        assertEquals(gamer1.getOponent(), gamer8);
        assertEquals(gamer3.getOponent(), gamer6);

    }

    @Test
    public void getOpponent() throws Exception {

        for (Gamer aGamers1 : gamers1) {
            GamerQueue.getInstance().addGamer(aGamers1);
        }

        for (Gamer aGamers1 : gamers2) {
            GamerQueue.getInstance().addGamer(aGamers1);
        }

        for (Gamer aGamers1 : gamers3) {
            GamerQueue.getInstance().addGamer(aGamers1);
        }

        Gamer opponent1 = GamerQueue.getInstance().getOpponent(gamer3);

        assertEquals(opponent1.getOponent(), gamer3);

        Gamer opponent2 = GamerQueue.getInstance().getOpponent(gamer7);

        assertEquals(gamer7.getOponent(), gamer4);



    }

}