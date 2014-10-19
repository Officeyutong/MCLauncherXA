/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipFile;
import javax.swing.JOptionPane;
import net.ytbolg.mcxa.Launcher.GameInfo;
import static net.ytbolg.mcxa.Launcher.GameInfo.tpf;

/**
 *
 * @author Ytong
 */
public class SkinmeGet {

    public static void getSkinme() {
        BufferedOutputStream bos = null;
        try {
            HttpURLConnection huc;
            URL u;
            URLConnection uc;
            boolean b = true;

            u = new URL("http://www.skinme.cc/mods/SkinMePatcher.zip");
            uc = u.openConnection();
            uc.connect();
            huc = (HttpURLConnection) uc;

            InputStream ips = huc.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(GameInfo.Rundir + tpf + "tmp.zip"));
            int byt = 0;
            while ((byt = ips.read()) != -1) {
                bos.write(byt);
            }
            new File(GameInfo.Rundir + tpf + "tmp.zip").delete();
            bos.flush();
            ips.close();
            bos.close();
            ZipFile zf = new ZipFile(GameInfo.Rundir + tpf + "tmp.zip");
            InputStream is;
            if (System.getProperty("os.arch").contains("86")) {
                is = zf.getInputStream(zf.getEntry("SkinMePatcher_x86.exe"));
            } else {
                is = zf.getInputStream(zf.getEntry("SkinMePatcher_x64.exe"));
            }
            bos = new BufferedOutputStream(new FileOutputStream(GameInfo.Rundir + tpf + "skinme.exe"));
            while ((byt = is.read()) != -1) {
                bos.write(byt);
            }
            bos.flush();
            bos.close();
            Runtime.getRuntime().exec(GameInfo.Rundir + tpf + "skinme.exe");
            new File(GameInfo.Rundir + tpf + "skinme.exe").deleteOnExit();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, Lang.getLang("DownFaild") + "\n" + ex, "", JOptionPane.ERROR_MESSAGE);
            // return;
        }
    }

}
