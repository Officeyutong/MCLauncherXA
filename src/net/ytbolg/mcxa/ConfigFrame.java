/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ytbolg.mcxa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.ytbolg.mcxa.Launcher.GameInfo;
import static net.ytbolg.mcxa.Launcher.GameInfo.tpf;
//import javax.swing.JLauncher.OptionPane;
//import static net.ytbolg.mcxa.GameInfo.tpf;

/**
 *
 * @author Ytong
 */
public class ConfigFrame extends javax.swing.JFrame {

    Properties p = new Properties();

    /**
     * Creates new form ConfigFrame
     */
    public ConfigFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("设置");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jButton1.setText("保存并关闭");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel4.setText("选择语言");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel5.setText("下载源");
        jLabel5.setToolTipText("");

        jComboBox1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel6.setText("注：语言更改将在重启后生效");

        jCheckBox3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jCheckBox3.setText("是否在启动信息窗口输出启动参数");

        jCheckBox2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jCheckBox2.setText("是否在启动成功后关闭启动信息窗口");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel1.setText("游戏目录");

        jTextField2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField2.setText("jTextField2");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jLabel2.setText("Java路径");

        jTextField3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField3.setText("jTextField3");

        jCheckBox1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jCheckBox1.setText("每个版本独立的文件夹");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOJANG", "BMCL" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel6)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(jTextField3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 258, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     //   String url = jTextField1.getText();
        /*        if (!url.startsWith("http")) {
         if (JOptionPane.showConfirmDialog(null, "你输入的库文件下载地址好像不是URL，仍然继续？", "提示", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
         return;
         }
         }*/
        String path = jTextField2.getText();
        File f = new File(path);
        if (!f.exists() || f.isFile()) {
            JOptionPane.showMessageDialog(rootPane, Lang.getLang("Set_ButtonEvent_NotAllow"), path, JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (path.endsWith("/") || path.endsWith("\\")) {
            path = path.substring(0, path.length() - 2);
        }
        Config.setConfig("GameDir", path);
        GameInfo.GameDir = path;
        Config.setConfig("ifclose", String.valueOf(jCheckBox2.isSelected()));
        Config.setConfig("showlauchinfo", String.valueOf(jCheckBox3.isSelected()));
    //    Config.setConfig("downUrl", url);
        Config.setConfig("Lang", Lang.getLangList(new File(GameInfo.Rundir + tpf + "MCXA.Lang"))[jComboBox1.getSelectedIndex()]);
        Config.setConfig("JavaPath", jTextField3.getText());
        Config.setConfig("isDuli", String.valueOf(jCheckBox1.isSelected()));
        Config.setConfig("DownSou", String.valueOf(jComboBox2.getSelectedIndex()));
        Config.Save();
//Config.setConfig(tpf, tpf);
        //     p.setProperty("showlauchinfowindows", String.valueOf(jCheckBox1.isSelected()));
//Config.setConfig("Lang", jComboBox1.getSelectedItem().toString().substring(0,jComboBox1.getSelectedItem().toString().lastIndexOf("(")));

        /*           ConfigClass.showlauchinfowindows = Boolean.valueOf(p.getProperty("showlauchinfowindows"));
         ConfigClass.showlauchinfo = Boolean.valueOf(p.getProperty("showlauchinfo"));
         ConfigClass.ifclose = Boolean.valueOf(p.getProperty("ifclose"));
         jCheckBox1.setSelected(ConfigClass.showlauchinfowindows);
         jCheckBox2.setSelected(ConfigClass.showlauchinfo);
         jCheckBox3.setSelected(ConfigClass.ifclose);*/
        dispose();
//this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //   jCheckBox1.setVisible(false);
        // jCheckBox2.setVisible(false);
        //jCheckBox3.setVisible(false);

        setTitle(Lang.getLang("Set_Title"));
        jCheckBox1.setText(Lang.getLang("Set_CheckBox_IsDulu"));
        jCheckBox2.setText(Lang.getLang("Set_CheckBox_Ifclose"));
        jCheckBox3.setText(Lang.getLang("Set_CheckBox_ShowArgs"));
        jButton2.setText(Lang.getLang("Set_Button_Cancel"));
        jButton1.setText(Lang.getLang("Set_Button_SaveAndClose"));
        jLabel4.setText(Lang.getLang("Set_Label_Lang"));
        jLabel5.setText(Lang.getLang("Set_Label_LibUrl"));
        jLabel6.setText(Lang.getLang("Set_Label_Warning"));
        jLabel1.setText(Lang.getLang("Set_Label_Minecraft"));
        jLabel2.setText(Lang.getLang("Set_Label_Javapath"));
        String list[] = Lang.getLangList(new File(GameInfo.Rundir + tpf + "MCXA.Lang"));
        jCheckBox2.setSelected(Config.getConfig("ifclose").equals("true"));
        jCheckBox3.setSelected(Config.getConfig("showlauchinfo").equals("true"));
        jCheckBox1.setSelected(Config.getConfig("isDuli").equals("true"));
//    System.out.println(Arrays.toString(list));
        for (int i = 0; i < list.length; i++) {
            //   String name1 = "";
            Properties p = new Properties();
            try {
                p.load(new FileReader(new File(GameInfo.Rundir + tpf + "MCXA.Lang" + tpf + list[i])));
            } catch (IOException ex) {
                Logger.getLogger(ConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            ((DefaultComboBoxModel) jComboBox1.getModel()).addElement(list[i] + "(" + p.getProperty("Lang") + ")");

        }
        jComboBox2.setSelectedIndex(Integer.valueOf(Config.getConfig("DownSou")));
     //   jTextField1.setText(Config.getConfig("downUrl"));
        //  ((DefaultComboBoxModel) jComboBox1.getModel()).addElement(evt);
        //  jCheckBox1.setSelected(ConfigClass.showlauchinfowindows);
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            if (jComboBox1.getItemAt(i).toString().contains(Config.getConfig("Lang"))) {
                jComboBox1.setSelectedIndex(i);
                break;
            }
        }
        jTextField2.setText(Config.getConfig("GameDir"));
        jTextField3.setText(Config.getConfig("JavaPath"));
        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
