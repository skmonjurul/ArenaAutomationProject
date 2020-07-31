package com.generic_methods;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonMethods {

public JSONObject readEnvConfigFile(){
    String fileName = System.getProperty("user.dir") + "/config_files/ENV_CONFIG.json";
    return readJsonFile(fileName);
}

public JSONObject readJsonFile(String fileName){
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = null;
    FileReader fileReader = null;
    try{
        fileReader = new FileReader(fileName);
        Object object = jsonParser.parse(fileReader);
        jsonObject = (JSONObject) object;
    }
    catch (IOException | ParseException ex){
        ex.printStackTrace();
    }
    finally {
        try{
            fileReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    return jsonObject;
}

public JSONObject getTestData(String config) throws AssertionError{
    JSONObject jsonObject = null;
        String fileName = System.getProperty("user.dir") + "/input/" + config + ".json";
        if(!isFileExist(fileName))
            throw new AssertionError();
        jsonObject = readJsonFile(fileName);
    return jsonObject;
}

public boolean isFileExist(String fileName){
    File file = new File(fileName);
    return file.exists();
}

public JSONObject getJsonObject(JSONObject jsonObject, String key){
    return (JSONObject) jsonObject.get(key);
}

public String getStringValueFromJson(JSONObject jsonObject, String key){
    return (String)jsonObject.get(key);
}

public int getIntegerValueFromJson(JSONObject jsonObject, String key){
    return Integer.parseInt(jsonObject.get(key).toString());
}

public String getCurrentDate(String format){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    Calendar calendar = Calendar.getInstance();
    return simpleDateFormat.format(calendar.getTime());
}

public String getDateAfterNoOfDays(String format, int days){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, days);
    return simpleDateFormat.format(calendar.getTime());
}

}
