/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mclaucherxa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Ytong
 */
public class Config {

    static ArrayList lvalue;
    static ArrayList rvalue;
    static File CfgFile;
    static Properties p = new Properties();

    public static void Load(File ConfigFile) throws FileNotFoundException, IOException {
        lvalue = new ArrayList();
        rvalue = new ArrayList();
        //  rvalue = new ArrayList();
        /*        FileReader fr = new FileReader(LangFile);
         char ch[] = new char[(int) LangFile.length()];
         fr.read(ch);*/
        CfgFile = ConfigFile;

        //"UTF-8"new InputStreamReader(new FileInputStream(LangFile)),"UTF-8")
        /*        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(LangFile),"UTF-8");
         BufferedInputStream bif=new BufferedInputStream();*/
        p.load(new FileReader(ConfigFile));
        System.out.println(ConfigFile);
        Object o[] = p.stringPropertyNames().toArray();
        for (Object o1 : o) {
            lvalue.add(o1.toString());
            //  System.out.println(o1.toString());
        }
        // while()
        for (int i = 0; i < p.size(); i++) {
            //  System.out.println(p.get(lvalue.get(i)));
            rvalue.add(p.get(lvalue.get(i)));
            //  p.propertyNames().
        }

    }

    public static String getConfig(String key) {

        if (!lvalue.contains(key)) {
            if (key.equals("GameDir")) {
                setConfig(key, GameInfo.GameDir);
            }
        }
        return rvalue.get(lvalue.indexOf(key)).toString();
    }

    public static void setConfig(String key, String value) {
        if (!lvalue.contains(key)) {
            rvalue.add(value);
            lvalue.add(key);
            p.setProperty(key, value);
        } else {
            rvalue.set(lvalue.indexOf(key), value);
            p.setProperty(key, value);
        }
    }

    public static void Save() {
        try {
            p.store(new FileWriter(CfgFile), "这是MClaucherXA的配置文件");
        } catch (IOException ie) {
        }
    }
}
