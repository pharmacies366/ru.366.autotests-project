package utils;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SimpleJSONMather {
    private String path = null;//json path элемента, к которому будет приминяться паттерн (регулярное выражение в двоёных фигурных скобках)
    private List<Customization> customizations = new ArrayList<>();//список паттернов и путей для json файла
    private JSONObject jsonObject;//json объект из файла

    /**
     * Проверка соответсвия ответа json файлу с регулярками и без
     * @param response
     * @param filePath
     */
    public void assertResponseByFile(String response, String filePath) {
        readJson(filePath);
        setCustomizations(jsonObject, path);
        try {
            JSONAssert.assertEquals(new String(Files.readAllBytes(Paths.get(filePath))),
                    response, new CustomComparator(
                            JSONCompareMode.STRICT,
                            customizations.toArray(new Customization[customizations.size()])
                    ));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Заполнение списка путей и паттернов.
     *
     * @param jsonObject - json обьект из которого формируется список.
     * @param path       - json path элемента, к которому будет приминяться паттерн.
     */
    private void setCustomizations(JSONObject jsonObject, String path) {
        for (Object key : jsonObject.keySet()) {
            path = path + "." + key.toString();

            if (jsonObject.get(key) instanceof String) {
                if (((String) jsonObject.get(key)).contains("{{")) {
                    path = path.replaceAll("null.", "");
                    String pattern = jsonObject.get(key).toString()
                            .replaceAll("\\{\\{", "")
                            .replaceAll("\\}\\}", "");
                    RegularExpressionValueMatcher matcher = new RegularExpressionValueMatcher<Object>(pattern);
                    customizations.add(new Customization(path, matcher));
                }
                path = null;
            }

            if (jsonObject.get(key) instanceof JSONObject) {
                setCustomizations((JSONObject) jsonObject.get(key), path);
                path = null;
            }

            if (jsonObject.get(key) instanceof JSONArray) {
                JSONArray array = (JSONArray) jsonObject.get(key);
                for (Object object : array) {
                    setCustomizations((JSONObject) object, path);
                }
                path = null;
            }
        }
    }

    /**
     * Чтение json из файла.
     *
     * @param filePath - Путь к файлу.
     */
    private void readJson(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
