package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

    private HashMap<String, String> hashMap;
    @BeforeEach
    void setUp() {
        hashMap = new HashMap<>();
    }

    @Test
    void testHashMap() {
        hashMap.put("city", "Norwich");
        assertEquals("Norwich", hashMap.get("city"));
        hashMap.put("city", "London");
        assertEquals("London", hashMap.get("city"));
        hashMap.clear();
        assertTrue((hashMap.isEmpty()));
        hashMap.put("town", null);
        assertNull(hashMap.get("town"));
    }git 

}