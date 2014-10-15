/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import static net.ytbolg.mcxa.GameInfo.tpf;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ytong
 */
public class GameInfoGet {

    static public Object[] getGameVersions() {
        //    String tpf = GameInfo.tpf;
        //   System.out.println(GameInfo.GameDir + tpf + "versions");
        File f = new File(GameInfo.GameDir + tpf + "versions");
        String a[] = f.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                //     System.out.println(name);
                //    System.out.println(dir);
                return new File(dir + GameInfo.tpf + name).isFile() == false;//To change body of generated methods, choose Tools | Templates.
            }
        });
        //    System.out.println(Arrays.toString(a));
        ArrayList t = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (IsMCVersion(GameInfo.GameDir + tpf + "versions" + tpf, a[i])) {
                t.add(a[i]);
            }
        }
        //System.out.println(Arrays.toString));
        return t.toArray();
    }

    static boolean IsMCVersion(String dir, String version) {
        boolean f = new File(dir + tpf + version + tpf + version + ".jar").exists();
        boolean b = new File(dir + tpf + version + tpf + version + ".json").exists();
        return b && f;
    }

    public static ArrayList getLibs(String version, String dir) throws FileNotFoundException, IOException, JSONException {
     //   System.out.println("什么破鸡巴语言4");//   System.out.println("getLibs");
        File file = new File(dir + tpf + "versions" + tpf + version + tpf + version + ".json");
        FileReader r = new FileReader(file);
        char c[] = new char[(int) file.length()];
        r.read(c);
        //   RandomAccessFile re = new RandomAccessFile(dir + tpf + "versions" + tpf + version + tpf + version + ".json", "rwd");
        //  FileReader r = new FileReader();
        //  BufferedReader br = new BufferedReader(r);
        //   byte c[] = new byte[(int) re.length() - 1];
        //   String tmp = "";
        String read = String.valueOf(c);
    //    System.out.println("start read libs");
        //    re.readFully(c);
     /* for(int xxxx=0;xxxx<c.length;xxxx++){
         read=read+Byte.toString(c[xxxx]);
         }*/
        //  read = Arrays.toString(c);

        //  System.out.println("read libs success");
        //  System.out.println(read);
        JSONArray ar = new JSONArray(new JSONObject(read).getString("libraries"));
        ArrayList al = new ArrayList();
        for (int i = 0; i < ar.length(); i++) {
            al.add(ar.getJSONObject(i));
        }
        return al;
    }

    public static String libstotruedir(ArrayList l, String dir) throws JSONException, IOException {
       // System.out.println("什么破鸡巴语言5");    //  System.out.println("start libs to true dir");
        GameInfo.NotFoundedLibs = new ArrayList();
        GameInfo.unzipAbledLibs = new ArrayList();
        String tmp = dir + tpf + "libraries";
        ArrayList temp = (ArrayList) l.clone();
        String a = "";
        //  System.out.println(getSys());
        for (int i = 0; i < temp.size(); i++) {
            String Native = "";
            if (((JSONObject) temp.get(i)).has("natives")) {
                Native = MakeNatives(((JSONObject) temp.get(i)).getJSONObject("natives"));
                //      GameInfo.unzipAbledLibs.add(i)
            }
            if (((JSONObject) temp.get(i)).has("rules")) {
                JSONArray ja = ((JSONObject) temp.get(i)).getJSONArray("rules");
                if (ja.length() == 1) {
                    if (ja.getJSONObject(0).getString("action").equals("disallow")) {
                        if (ja.getJSONObject(0).toString().contains(getSys())) {
                    //        System.out.println(ja.getJSONObject(0).toString());
                            continue;
                        }
                    }
                    if (ja.getJSONObject(0).getString("action").equals("allow")) {
                        if (!ja.getJSONObject(0).toString().contains(getSys())) {
                          //  System.out.println(ja.getJSONObject(0).toString());
                            continue;
                        }
                    }
                }
                if (ja.length() == 2) {
                    if (ja.getJSONObject(1).getString("action").equals("disallow")) {
                        if (ja.getJSONObject(1).toString().contains(getSys())) {
                         //   System.out.println(ja.getJSONObject(1).toString());
                            continue;
                        }
                    }

                }

            }
      //    System.out.println("神魔破鸡巴语言6");
            String x = ((JSONObject) temp.get(i)).getString("name");
            String e = x;

            String c = "";
            String s[] = x.split(":");
            for (int xci = 0; xci < s.length - 2; xci++) {
                c = c + s[xci].replace(".", tpf) + tpf;
            }
            c = c + s[s.length - 2] + tpf + s[s.length - 1];
            /*     String z = x.substring(0, x.lastIndexOf(":"));
             x = x.substring(x.lastIndexOf(":"));
             z = z.replace(".", tpf);
             x = x.replace(":", tpf);*/

            //   c = z + x;
            c = c.replace(":", tpf);
            String cc[] = e.split(":");
            String cd = "";
            //     System.out.println(e);
            //   System.out.println(cc.length);
            if (cc.length >= 2) {

                cd = cc[cc.length - 2] + "-" + cc[cc.length - 1] + Native + ".jar";
                //   System.out.println(cd+"Check");
            }
            //   System.out.println(new File(dir + tpf + "libraries" + tpf + c + tpf + cd).exists());
            //       System.out.println(new File(dir + tpf + "libraries" + tpf + c + tpf + cd).exists() ? "Notfound:" + dir + tpf + "libraries" + tpf + c + tpf + cd : "");
            cd = cd.replace("$", "");
            cd = cd.replace("{", "");
            cd = cd.replace("}", "");
            cd = cd.replaceAll("arch", System.getProperty("sun.arch.data.model"));
            if (new File(dir + tpf + "libraries" + tpf + c + tpf + cd).exists() == false) {

                if (cd.contains("nightly")) {
                    continue;
                }
                //   System.out.println(
                //    "未找到" + tpf + c + tpf + cd);
                GameInfo.NotFoundedLibs.add(tpf + c + tpf + cd);
//  System.out.print();;
                //    System.out.println(GameInfo.NotFoundedLibs.isEmpty());
            }
            if (Native.equals("") == false) {
                GameInfo.unzipAbledLibs.add(dir + tpf + "libraries" + tpf + c + tpf + cd);
                continue;
            }

          //  Runtime.getRuntime().exec("chmod 777 " + dir + tpf + "libraries" + tpf + c + tpf + cd);

            String h = "\"";
            String j = ";";
            if (!System.getProperty("os.name").contains("Windows")) {
              h="'";
                j = ":";
            }
            a = a + h + dir + tpf + "libraries" + tpf + c + tpf + cd + h + j;
            //  c=c.replaceAll(tpf+tpf, tpf);
        }

        return a;
    }

    static String MakeNatives(JSONObject natives) throws JSONException {

        if (natives.has("windows") && getSys().equals("windows")) {
            return "-" + natives.getString("windows");
        }
        if (natives.has("linux") && getSys().equals("linux")) {
            return "-" + natives.getString("linux");
        }
        if (natives.has("osx") && getSys().equals("osx")) {
            return "-" + natives.getString("osx");
        }
        return "";

    }

    static String getSys() {
        String t = System.getProperty("os.name");
       
        if (t.contains("Windows")) {
            return "windows";
        }
        if (t.contains("Linux")) {
            return "linux";
        }
        if (t.contains("Mac")) {
            return "osx";
        }
        return null;
    }
}
