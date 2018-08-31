package ru.csc.java.testing.demo3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {

    @Test
    public void default_constructor_should_create_empty_map() {
        Map<String, String> map = new HashMap<>();

        assertThat(map).isEmpty();
        assertThat(map).hasSize(0).doesNotContainKey("x");

        assertThat(map.entrySet().iterator().hasNext()).isFalse();
    }


    @Test
    public void collection_constructor_should_copy_all_content() {
        Map<String, String> originalMap = new HashMap<>();
        originalMap.put("a", "b");
        originalMap.put("c", "d");

        Map<String, String> copiedMap = new HashMap<>(originalMap);

        assertThat(copiedMap)
                .describedAs("copied map")
                .hasSize(2)
                .isEqualTo(originalMap)
                .isNotSameAs(originalMap);

        originalMap.put("e", "f");

        assertThat(copiedMap)
                .hasSize(2)
                .doesNotContain(entry("e", "f"))
                .isNotEqualTo(originalMap);
    }
}
