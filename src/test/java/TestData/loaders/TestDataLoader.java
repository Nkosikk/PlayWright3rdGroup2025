package TestData.loaders;

import TestData.models.SignUpTestData;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.nio.file.Paths;

public class TestDataLoader {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String BASE_PATH = "src/test/resources/test-data/";

    public static <T> T get(String fileName, String key, Class<T> clazz) {
        try {
            JsonNode root = mapper.readTree(
                    Paths.get(BASE_PATH + fileName).toFile()
            );
            return mapper.treeToValue(root.get(key), clazz);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load test data from " + fileName, e
            );
        }
    }
}

