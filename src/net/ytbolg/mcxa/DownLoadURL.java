/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa;

/**
 *
 * @author Ytong
 */
public class DownLoadURL {

    private static final String versions[] = new String[]{"https://s3.amazonaws.com/Minecraft.Download/versions", "http://bmclapi.bangbang93.com/versions"};
    private static final String libraries[] = new String[]{"https://libraries.minecraft.net", "http://bmclapi.bangbang93.com/libraries"};
    private static final String indexes[] = new String[]{"https://s3.amazonaws.com/Minecraft.Download/indexes", "http://bmclapi.bangbang93.com/indexes"};
    private static final String versionlist[] = new String[]{"https://s3.amazonaws.com/Minecraft.Download/versions/versions.json", "http://bmclapi.bangbang93.com/mcversions/versions.json"};
    private static final String optifine[] = new String[]{"http://optifine.net/downloads.php", "http://bmclapi.bangbang93.com/optifine/versionlist"};
    private static final String assets[] = new String[]{"http://resources.download.minecraft.net", "http://bmclapi.bangbang93.com/assets/"};
    public final static int VERSION = 0;
    public final static int LIBRARIES = 1;
    public final static int INDEXES = 2;
    public final static int VERSION_LIST = 3;
    public final static int OPTIFINE = 4;
    public final static int ASSETS = 5;

    public final static int MOJANG = 0;
    public final static int BMCL = 1;

    public static String getURL(int type, int v) {
        String t = "";
        switch (type) {
            case 0:
                t = versions[v];
                break;

            case 1:
                t = libraries[v];
                break;
            case 2:
                t = indexes[v];
                break;
            case 3:
                t = versionlist[v];
                break;
            case 4:
                t = optifine[v];
                break;
            case 5:
                t = assets[v];
                break;
        }
        System.out.println(type);
        System.out.println(v);
        System.out.println(t);
        return t;
    }
}
