/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa.Launcher;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import net.ytbolg.mcxa.Config;
import static net.ytbolg.mcxa.Launcher.GameInfo.tpf;
//import static mclaucherxa.GameInfo.tpf;

/**
 *
 * @author Ytong
 */
public class MakeCmd {

    public static String MakeCmd(String libs, String args, String memory, String version, String mainclass) {
        //   System.out.println("Making cmd");
        String tpf = GameInfo.tpf;
        String t = "";
        String fgf = System.getProperty("os.name").contains("Linux") ? "'" : "\"";
        t = " -Xmx" + memory + " "/*" -Dfml.ignorePatchDiscrepancies=true*/ + "-Djava.library.path=" + fgf + GameInfo.GameDir + tpf + "versions" + tpf + version + tpf + "Natives" + fgf + " -classpath " + libs + fgf + GameInfo.GameDir + tpf + "versions" + tpf + version + tpf + version + ".jar" + fgf + " ";
        //   System.out.println("Making Ok");
        t = t + mainclass + " ";
        t = t + args;
        //         System.out.println("Will return");
        t = t.replaceAll("-nightly-20131017", "");
        return t;
    }

    public static String ReplaceArgs(String args, String username, String version, String token,String twitchToken) throws PatternSyntaxException {
        String tpf = GameInfo.tpf;
        //String x = "";
        String fgf = System.getProperty("os.name").contains("Linux") ? "'" : "\"";
        String tmp = args;
        tmp = tmp.replace("$", "");
        tmp = tmp.replace("{", "");
        tmp = tmp.replace("}", "");
        //x = ;
        tmp = tmp.replaceAll("auth_player_name", username);
        //x = ;
        tmp = tmp.replaceAll("version_name", version);
        //x =;
        String gamedir = "";
        if (Config.getConfig("isDuli").equals("true")) {
            gamedir = fgf + GameInfo.GameDir + tpf + "versions" + tpf + version + fgf;
        } else {
            gamedir = fgf + GameInfo.GameDir + fgf;
        }
        tmp = tmp.replaceAll("game_directory", Matcher.quoteReplacement(gamedir));
        //  x = ;
        tmp = tmp.replaceAll("game_assets", Matcher.quoteReplacement(GameInfo.GameDir + tpf + "assets" + tpf + "virtual" + tpf + "legacy" + tpf));
        tmp = tmp.replaceAll("assets_root", Matcher.quoteReplacement(fgf + GameInfo.GameDir + tpf + "assets" + fgf));
        tmp = tmp.replaceAll("user_type", "legacy");
        tmp = tmp.replaceAll("user_properties", Matcher.quoteReplacement(twitchToken));
        if (version.length() > 6) {
            if (version.contains("-")) {
                version = version.substring(0, version.indexOf("-"));
            }
        }
        tmp = tmp.replaceAll("assets_index_name", version);
        tmp = tmp.replaceAll("auth_access_token", token);
        if (GameInfo.uuid.equals("")) {
            GameInfo.uuid = "auth_uuid";
        }
        tmp = tmp.replaceAll("auth_uuid", GameInfo.uuid);
        return tmp;
    }

}
