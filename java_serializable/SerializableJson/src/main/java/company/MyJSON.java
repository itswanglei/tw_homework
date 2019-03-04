package main.java.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyJSON {
    public String readFile(String filePath) {
        if (null != filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))){
                String str;
                StringBuilder content = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    Pattern pattern = Pattern.compile("\\s*");
                    Matcher matcher = pattern.matcher(str);
                    content.append(matcher.replaceAll(""));
                }
                return content.toString().replace("\\s*", "");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        return null;
    }

    public boolean isJSON(String string) {
        if (!string.startsWith("{") || !string.endsWith("}")) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\w*:");
        String[] JSONArray = string.substring(1, string.length() - 1).split(",");
        for (String str : JSONArray) {
            String[] keyAndValue = str.split(":");
            if (1 == keyAndValue.length) {
                return false;
            }
            if (!keyAndValue[0].startsWith("\"") || !keyAndValue[0].endsWith("\"")) {
                return false;
            }
            if (keyAndValue[1].startsWith("{") && keyAndValue[1].endsWith("}")) {
                this.isJSON(keyAndValue[1]);
            }
        }
        return true;
    }
}
