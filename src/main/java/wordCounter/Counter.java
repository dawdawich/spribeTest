package wordCounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Counter {

    private static volatile Counter instance;
    private ConcurrentHashMap<String, Integer> wordsMap = new ConcurrentHashMap<>();

    public static Counter getInstance() {
        Counter localInstance = instance;
        if (localInstance == null) {
            synchronized (Counter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Counter();
                }
            }
        }
        return localInstance;
    }

    public void addWord (String word)
    {
        if (wordsMap.containsKey(word.toLowerCase()))
        {
            wordsMap.put(word.toLowerCase(), wordsMap.get(word.toLowerCase()) + 1);
        }
        else
        {
            wordsMap.put(word.toLowerCase(), 1);
        }
    }

    public int getWordCount (String word)
    {
        return wordsMap.getOrDefault(word.toLowerCase(), 0);
    }

}
