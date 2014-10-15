/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mclaucherxa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Ytong
 */
public class Lang {

   
    public static ArrayList lvalue;
    public static ArrayList rvalue;

    public static void Load(File LangFile) throws FileNotFoundException, IOException {
        lvalue = new ArrayList();
        rvalue = new ArrayList();
        //  rvalue = new ArrayList();
        /*        FileReader fr = new FileReader(LangFile);
         char ch[] = new char[(int) LangFile.length()];
         fr.read(ch);*/
        Properties p = new Properties();
        //"UTF-8"new InputStreamReader(new FileInputStream(LangFile)),"UTF-8")
        /*        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(LangFile),"UTF-8");
         BufferedInputStream bif=new BufferedInputStream();*/
        p.load(new FileReader(LangFile));
        Object o[] = p.stringPropertyNames().toArray();
        for (Object o1 : o) {
            lvalue.add(o1.toString());
            // System.out.println(o1.toString());
        }
        // while()
        for (int i = 0; i < p.size(); i++) {
            //  System.out.println(p.get(lvalue.get(i)));
            rvalue.add(p.get(lvalue.get(i)));
            //  p.propertyNames().
        }

    }

    public static String getLang(String key) {
        if (!lvalue.contains(key)) {
            System.out.println("未知语言ID" + key);
        }
        if (!lvalue.contains(key)) {
           
            System.out.println("未找到对应语言文本:" + key + "=");
            return "Unknow LangKey:"+key;
        }
        return rvalue.get(lvalue.indexOf(key)).toString();
    }

    public static String[] getLangList(File LangPath) {
        return LangPath.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".lang")) {
                    return true;
                } else {
                    return false;
                }
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }
}
