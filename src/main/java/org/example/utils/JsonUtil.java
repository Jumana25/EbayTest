package org.example.utils;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    public static JSONObject parseJsonFile(String fileName) throws IOException, ParseException {
        return (JSONObject) (new JSONParser()).parse(new FileReader("src/test/resources/TestData/"+fileName));
//        return (JSONObject) (new JSONParser()).parse(new FileReader(Paths.get("src", "test", "resources", "TestData").toAbsolutePath().toString()));
    }

    public static JSONObject getJsonObjectFromFile(String fileName, String objectName) throws IOException, ParseException {
        return (JSONObject) parseJsonFile(fileName).get(objectName);
    }
}
