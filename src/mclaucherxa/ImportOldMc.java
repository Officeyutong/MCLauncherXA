/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mclaucherxa;
//实在做不下去了
import java.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mclaucherxa.GameInfo.tpf;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ytong
 */
public class ImportOldMc implements Runnable {

    private String json = "{\n"
            + "	\"id\": \"%NAME\",\n"
            + "	\"time\": \"%TIME\",\n"
            + "	\"releaseTime\": \"%RelTime\",\n"
            + "	\"type\": \"ImportedByMCXA\",\n"
            + "	\"minecraftArguments\": \"${auth_player_name}\"\n"
            + "	\"libraries\": %LIB\n"
            + "		\n"
            + "	,\n"
            + "	\"mainClass\": \"net.minecraft.client.Minecraft\",\n"
            + "	\"minimumLauncherVersion\": 9\n"
            + "}";
    private String oldVersionPath = "";
    private String newVersionName = "";

    public void Config(String a, String b) {
        oldVersionPath = a;
        newVersionName = b;
    }

    @Override
    public void run() {
        JSONArray ja = new JSONArray();
        File ovp = new File(oldVersionPath);
        File jars[] = ovp.listFiles(new FilenameFilter() {
            

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        String libpath = GameInfo.GameDir + tpf + "libraries";
        for (int i = 0; i < jars.length; i++) {
            File t = new File(libpath + tpf + "MCXA" + tpf + "MCXA-"+jars[i].getName());
            JSONObject jo=new JSONObject();
            fileChannelCopy(jars[i], t);
            try {
                jo.put("name", "MCXA:"+jars[i].getName());
                
            } catch (JSONException ex) {}
            ja.put(jo.toString());
        }
       // copyFolder(oldVersionPath+tpf+"native", libpath);

    }

   void fileChannelCopy(File s, File t) {

        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//得到对应的文件通道

            out = fo.getChannel();//得到对应的文件通道

            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                fi.close();

                in.close();

                fo.close();

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
      public void copyFolder(String oldPath, String newPath) { 

       try { 
           (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
           File a=new File(oldPath); 
           String[] file=a.list(); 
           File temp=null; 
           for (int i = 0; i < file.length; i++) { 
               if(oldPath.endsWith(File.separator)){ 
                   temp=new File(oldPath+file[i]); 
               } 
               else{ 
                   temp=new File(oldPath+File.separator+file[i]); 
               } 

               if(temp.isFile()){ 
                   FileInputStream input = new FileInputStream(temp); 
                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
                           (temp.getName()).toString()); 
                   byte[] b = new byte[1024 * 5]; 
                   int len; 
                   while ( (len = input.read(b)) != -1) { 
                       output.write(b, 0, len); 
                   } 
                   output.flush(); 
                   output.close(); 
                   input.close(); 
               } 
               if(temp.isDirectory()){//如果是子文件夹 
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
               } 
           } 
       } 
       catch (Exception e) { 
           System.out.println("复制整个文件夹内容操作出错"); 
           e.printStackTrace(); 

       } 

   }
}
