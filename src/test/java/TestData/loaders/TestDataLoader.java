package TestData.loaders;

import TestData.models.SignUpTestData;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.nio.file.Paths;

public class TestDataLoader {
    public static SignUpTestData get(String key) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(
                    Paths.get("src/test/resources/test-data/signupData.json").toFile()
            );
            return mapper.treeToValue(root.get(key), SignUpTestData.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }
}
