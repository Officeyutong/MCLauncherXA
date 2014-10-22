/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa;

import net.ytbolg.mcxa.Launcher.GameInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ytong
 */
public class Config {

    static File CfgFile;
    static JSONObject p = new JSONObject();
    private static String t = "";

    static String getNormalValue(String key) {
//String r="";
        switch (key) {
            case "lastmemory":
                t = "1500";
                break;
            case "ifclose":
                t = "true";
                break;
            case "showlauchinfo":
                t = "true";
                break;

            case "JavaPath":
                t = GameInfo.JavaPath;
                break;
            case "username":
                t = "playerXXX";
                break;
            case "Lang":
                t = "sChinese.lang";
                break;
            case "lastgameversion":
                t = "0";
                break;
            case "iszhengban":
                t = "false";
                break;
            case "GameDir":
                t = GameInfo.GameDir;
                break;
            case "isDuli":
                t = "false";
                break;
            case "zhengbanmima":
                t = "";
                break;
            case "DownSou":
                t = "1";
                break;

        }
        return t;
    }

    public static void Load(File ConfigFile) {
        try {
            //  rvalue = new ArrayList();
        /*        FileReader fr = new FileReader(LangFile);
             char ch[] = new char[(int) LangFile.length()];
             fr.read(ch);*/
            if (!ConfigFile.exists()) {
                ConfigFile.createNewFile();
            }
            CfgFile = ConfigFile;

            //"UTF-8"new InputStreamReader(new FileInputStream(LangFile)),"UTF-8")
        /*        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(LangFile),"UTF-8");
             BufferedInputStream bif=new BufferedInputStream();*/
            p = new JSONObject(ReadFile(ConfigFile.toString()));
            System.out.println(ConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            /*        try {
             p = null;
             ConfigFile.delete();
             ConfigFile.createNewFile();
             p = new JSONObject(ReadFile(ConfigFile.toString()));
             } //  Object o[] = p.stringPropertyNames().toArray();
             catch (IOException ex) {
             Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
             } catch (JSONException ex) {
             Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
             }*/
        }

    }

    public static String getConfig(String key) {

        if (!p.has(key)) {
            setConfig(key, getNormalValue(key));
        }
        try {
            return p.getString(key);
        } catch (JSONException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void setConfig(String key, String value) {
        try {

            p.put(key, value);

        } catch (JSONException e) {e.printStackTrace();
        }
    }

    public static void Save() {
        try {
            FileWriter fw = new FileWriter(CfgFile);
            fw.write(p.toString());
            fw.close();
//   p.write();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    static String ReadFile(String path) throws FileNotFoundException, IOException {

        File file = new File(path);
        FileReader r = new FileReader(file);
        char c[] = new char[(int) file.length()];
        r.read(c);
        System.out.println(String.valueOf(c));
        return String.valueOf(c);
    }
}
