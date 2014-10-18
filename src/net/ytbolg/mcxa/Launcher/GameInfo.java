/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa.Launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *
 * @author Ytong
 */
public class GameInfo {
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();

            for (String children1 : children) {
                boolean success = deleteDir(new File(dir, children1));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    
    public static String assVersion="";
    public static String GameDir = "";
    public static String tpf = "";
    public static String JavaPath = "";
    public static ArrayList unzipAbledLibs;
    public static ArrayList NotFoundedLibs;
    public static String UserName = "";
    public static String memory = "";
    public static String Rundir = "";
    public static String token = "";
    public static String downUrl = "";
    public static boolean Downok = false;
    public static String twitchToken = "";
    public static String uuid = "";
    //   public static ResourceBundle rb;

}
