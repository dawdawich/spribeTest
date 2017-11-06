package findOponent;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class GamerQueue {

    private static volatile GamerQueue instance;
    private ConcurrentSkipListSet<Gamer> readyGamers = new ConcurrentSkipListSet();

    public static GamerQueue getInstance() {
        GamerQueue localInstance = instance;
        if (localInstance == null) {
            synchronized (GamerQueue.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new GamerQueue();
                }
            }
        }
        return localInstance;
    }

    public void addGamer (Gamer gamer)
    {
        gamer.setReady(true);
        readyGamers.add(gamer);
    }

    public void placeOpponents ()
    {
        Iterator<Gamer> iterator = readyGamers.iterator();
        while (iterator.hasNext())
        {
            Gamer gamer = iterator.next();
            if (!iterator.hasNext())
            {
                return;
            }
            Gamer nextGamer = iterator.next();

            gamer.setOponent(nextGamer);
            nextGamer.setOponent(gamer);
            readyGamers.remove(gamer);
            readyGamers.remove(nextGamer);
        }
    }

    public Gamer getOpponent (Gamer gamer)
    {
        if (!readyGamers.contains(gamer))
        {
            readyGamers.add(gamer);
        }

        if (readyGamers.size() <= 1) return null;
        else {

            Gamer higherRateGamer = readyGamers.higher(gamer);
            Gamer lowerRateGamer = readyGamers.lower(gamer);
            Gamer opponent;

            if ((higherRateGamer == null && lowerRateGamer != null) || (higherRateGamer != null && lowerRateGamer == null)) {
                opponent = higherRateGamer != null ? higherRateGamer : lowerRateGamer;
            }
            else {
                assert higherRateGamer != null;
                opponent = (higherRateGamer.getRate() - gamer.getRate() < gamer.getRate() - lowerRateGamer.getRate()) ? higherRateGamer : lowerRateGamer;
            }
            gamer.setOponent(opponent);
            opponent.setOponent(gamer);
            readyGamers.remove(opponent);
            readyGamers.remove(gamer);
            return opponent;
        }
    }

}
