/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mclaucherxa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class YggdrasilCheck {

    public static YggdrasilCheck getThis() {

        return new YggdrasilCheck();
    }

    public String login(String json) throws IOException,ConnectException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        
            URL realUrl = new URL("https://authserver.mojang.com/authenticate");
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(json);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
  //使用finally块来关闭输出流、输入流
       
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        
        return result;

        // return null;}
    }

    public String GenLoginJson(String email, String pass) {
        //  InputStream json = getClass().getResourceAsStream("/Login.json");
        String json = "{\n"
                + "    \"agent\": {\n"
                + "        \"name\": \"Minecraft\",\n"
                + "        \"version\": 1\n"
                + "\n"
                + "    },\n"
                + "    \"username\": \"%email\",\n"
                + "    \"password\": \"%password\",\n"
                
                + "    \"requestUser\": true\n"
                + "}";
        json = json.replaceAll("%email", email);
        json = json.replaceAll("%password", pass);

        json = json.replaceAll("%token", GameInfo.uuid);
        return json;
    }
}
