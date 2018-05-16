package map_sorter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {
	
    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue((v1, v2) -> v2 - v1));

        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
    
    public static <K, V> void printMap(Map<K, V> map) {
    	for(Map.Entry<K, V> entry : map.entrySet()) {      
    	    System.out.println(entry.getKey() + ": " + entry.getValue());      
    	} 
    }
}
