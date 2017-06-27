/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otp.encoder;

//import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sir_Kibble
 * 
 */
public class OTPFrame extends javax.swing.JFrame {
    private final Encoder OTPEncoder;
    //private String key, text;
    public OTPFrame() {
        this.OTPEncoder = new ForLoopEncoder();
        initComponents();
        this.AlphabetButton.setSelected(true);
        //this.plainText.setWrapStyleWord(true);
        //this.keyText.setWrapStyleWord(true);
        //inputStorage = "";
        //outputStorage = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        plainText = new javax.swing.JTextArea();
        DecryptButton = new javax.swing.JButton();
        EncryptButton = new javax.swing.JButton();
        AlphabetButton = new javax.swing.JRadioButton();
        UnicodeButton = new javax.swing.JRadioButton();
        NumericButton = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OpenKeyMenuOption = new javax.swing.JMenuItem();
        OpenMessageMenuOption = new javax.swing.JMenuItem();
        SaveKeyMenuOption = new javax.swing.JMenuItem();
        SaveMessageMenuOption = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OTP Helper");
        setAutoRequestFocus(false);
        setLocationByPlatform(true);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        keyText.setColumns(20);
        keyText.setLineWrap(true);
        keyText.setRows(5);
        keyText.setText("OTP Key");
        keyText.setToolTipText("Type/Paste key to encode or decode on here.");
        keyText.setWrapStyleWord(true);
        keyText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keyTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keyTextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(keyText);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        plainText.setColumns(20);
        plainText.setLineWrap(true);
        plainText.setRows(5);
        plainText.setText("Encrypted/plaintext text");
        plainText.setWrapStyleWord(true);
        plainText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                plainTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                plainTextFocusLost(evt);
            }
        });
        plainText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plainTextMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(plainText);

        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        EncryptButton.setText("Encrypt");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(AlphabetButton);
        AlphabetButton.setText("Alphabet");

        buttonGroup1.add(UnicodeButton);
        UnicodeButton.setText("Unicode");
        UnicodeButton.setEnabled(true);

        buttonGroup1.add(NumericButton);
        NumericButton.setText("0-9");

        jMenu1.setText("Menu");

        OpenKeyMenuOption.setText("Open key");
        OpenKeyMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenKeyMenuOptionActionPerformed(evt);
            }
        });
        jMenu1.add(OpenKeyMenuOption);

        OpenMessageMenuOption.setText("Open message");
        OpenMessageMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMessageMenuOptionActionPerformed(evt);
            }
        });
        jMenu1.add(OpenMessageMenuOption);

        SaveKeyMenuOption.setText("Save key");
        SaveKeyMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveKeyMenuOptionActionPerformed(evt);
            }
        });
        jMenu1.add(SaveKeyMenuOption);

        SaveMessageMenuOption.setText("Save message");
        SaveMessageMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMessageMenuOptionActionPerformed(evt);
            }
        });
        jMenu1.add(SaveMessageMenuOption);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Instructions");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
            .add(jScrollPane2)
            .add(layout.createSequentialGroup()
                .add(NumericButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(UnicodeButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(AlphabetButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(EncryptButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(DecryptButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(AlphabetButton)
                        .add(UnicodeButton)
                        .add(EncryptButton)
                        .add(DecryptButton))
                    .add(NumericButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        //temp values
        String finalOutput;
        finalOutput = "";
           
        //33-126
        if(this.AlphabetButton.isSelected()){//if alphabetic is selected 97-122
            //Encoder.setOptions(26, 97);
            //Encoder.setEncypher(OTPEncoder.EncypherType.alphabet);
            this.plainText.setText(OTPEncoder.decode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.alphabet));
            
        }//end if alphabetic
        else if(this.UnicodeButton.isSelected()){
            //Encoder.setOptions(1114112, 0);
            //Encoder.setEncypher(OTPEncoder.EncypherType.unicode);
            this.plainText.setText(OTPEncoder.decode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.unicode));            
            
        }//end unicode
        else if(this.NumericButton.isSelected()){
            //Encoder.setOptions(10, 48);
            //Encoder.setEncypher(OTPEncoder.EncypherType.numeric);
            this.plainText.setText(OTPEncoder.decode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.numeric));            
            
        }//end numeric
        else{
            //Encoder.setOptions(26, 97);
        }//default case
        //this.plainText.setText(OTPEncoder.decode(this.plainText.getText(), this.keyText.getText())); 
    }//GEN-LAST:event_DecryptButtonActionPerformed

    private void keyTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keyTextFocusGained
        //key = this.keyText.getText();
        this.keyText.selectAll();
        
    }//GEN-LAST:event_keyTextFocusGained

    private void keyTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keyTextFocusLost
        if(this.keyText.getText().equals(""))
            this.keyText.setText("OTP Key");
    }//GEN-LAST:event_keyTextFocusLost

    private void plainTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plainTextFocusGained
        this.plainText.selectAll();
    }//GEN-LAST:event_plainTextFocusGained

    private void OpenMessageMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMessageMenuOptionActionPerformed
        //opening files
        JFileChooser FC = new JFileChooser();
        File file;
        int fcVal = FC.showOpenDialog(this);
        String Key = "";
        
        if(fcVal == JFileChooser.APPROVE_OPTION){
            file = FC.getSelectedFile();
            try{
                char str;
                BufferedReader bufReader = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8"));
                while(bufReader.ready())
                {
                    str = (char) bufReader.read();
                    Key += str;
                }
                /*String str;
            BufferedReader bufReader = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while((str=bufReader.readLine())!=null)
            {
                Key += str;
            }
                
                /*InputStreamReader input = new InputStreamReader(new FileInputStream(file)/*, StandardCharsets.UTF_8);
                while(input.ready()){
                    Key += input.read();
                }//end while
                
                /*BufferedReader textReader = new BufferedReader(input);
                while(textReader.ready()){
                    Key += textReader.read();
                }//end while*/
            }catch(IOException e){
                    JOptionPane.showMessageDialog(this, "Error opening file: \n"+e.getMessage(), "File Error!", JOptionPane.ERROR_MESSAGE);
            }//end catch
            this.plainText.setText(Key);
        }//end if
    }//GEN-LAST:event_OpenMessageMenuOptionActionPerformed

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed
        //temp values
           
        //33-126
        if(this.AlphabetButton.isSelected()){//if alphabetic is selected 97-122
            //Encoder.setOptions(26, 97);
            //Encoder.setEncypher(OTPEncoder.EncypherType.alphabet);
            
            this.plainText.setText(OTPEncoder.encode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.alphabet));            
        }//end if alphabetic
        else if(this.UnicodeButton.isSelected()){
            //Encoder.setOptions(1114112, 0);
            //Encoder.setEncypher(OTPEncoder.EncypherType.unicode);
            this.plainText.setText(OTPEncoder.encode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.unicode));
        }//end unicode
        else if(this.NumericButton.isSelected()){
            //Encoder.setOptions(10, 48);
            //Encoder.setEncypher(OTPEncoder.EncypherType.numeric);
            this.plainText.setText(OTPEncoder.encode(this.plainText.getText(), this.keyText.getText(), Encoder.EncypherType.numeric));
        }//end numeric
        else{
            //Encoder.setOptions(26, 97);
        }//default case
        //this.plainText.setText(OTPEncoder.encode(this.plainText.getText(), this.keyText.getText())); 
                                                 
    }//GEN-LAST:event_EncryptButtonActionPerformed
    
    private void plainTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plainTextMouseClicked
        this.plainText.selectAll();
    }//GEN-LAST:event_plainTextMouseClicked

    private void plainTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_plainTextFocusLost
        if(this.plainText.getText().equals(""))
            this.plainText.setText("Encrypted/plaintext text goes here.  "+"This program supports encyphering on 3 types of strings: \n"
        + "numeric, english alphabet(lowercase only, no spaces), and unicode.\n"
        + "While you can encypher/decypher mixing key and message types, it's\n"
        + "unstable and not recommended.");
    }//GEN-LAST:event_plainTextFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(this, "Created by: Sir_Kibble, April 2016"
                + "\n v1.2\ncontact insomniac_66@hotmail.com", "About OTP", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
JOptionPane.showMessageDialog(this, 
        "This program supports encyphering on 3 types of strings: \n"
        + "numeric, english alphabet(lowercase only, no spaces), and unicode.\n"
        + "While you can encypher/decypher mixing key and message types, it's\n"
        + "unstable and not recommended"
        + "", "Instructions", JOptionPane.INFORMATION_MESSAGE);    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void OpenKeyMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenKeyMenuOptionActionPerformed
        //opening files
        JFileChooser FC = new JFileChooser();
        File file;
        int fcVal = FC.showOpenDialog(this);
        String Key = "";
        
        if(fcVal == JFileChooser.APPROVE_OPTION){
            file = FC.getSelectedFile();
            try{
                char str;
                BufferedReader bufReader = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8"));
                while(bufReader.ready())
                {
                    str = (char) bufReader.read();
                    Key += str;
                }
                /*InputStreamReader input = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_16);
                while(input.ready()){
                    Key += input.read();
                }//end while
                
                /*BufferedReader textReader = new BufferedReader(input);
                while(textReader.ready()){
                    Key += textReader.read();
                }//end while*/
            }catch(IOException e){
                    JOptionPane.showMessageDialog(this, "Error opening file: \n"+e.getMessage(), "File Error!", JOptionPane.ERROR_MESSAGE);
            }//end catch
            this.keyText.setText(Key);
        }//end if
    }//GEN-LAST:event_OpenKeyMenuOptionActionPerformed

    private void SaveKeyMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveKeyMenuOptionActionPerformed
        //save dialog for Key
        JFileChooser FC = new JFileChooser();
        File file;
        int fcVal = FC.showSaveDialog(this);
        String Key = this.keyText.getText();
        
        if(fcVal == JFileChooser.APPROVE_OPTION){
            file = FC.getSelectedFile();
        
            try (Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(FC.getSelectedFile().getAbsolutePath()+".key"), "UTF-8"))) {
                out.write(Key);
            } catch (IOException ex) {
                Logger.getLogger(OTPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*try {
                FileWriter fw = new FileWriter(FC.getSelectedFile()+".txt");
                fw.write(Key);
            } catch(Exception e){
            }*/
            /*try {
            FileWriter fw = new FileWriter(FC.getSelectedFile()+".txt");
            fw.write(Key);
            } catch(Exception e){
            }*/        }
    }//GEN-LAST:event_SaveKeyMenuOptionActionPerformed

    private void SaveMessageMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMessageMenuOptionActionPerformed
        //save dialog for message
        JFileChooser FC = new JFileChooser();
        File file;
        int fcVal = FC.showSaveDialog(this);
        String Key = this.plainText.getText();
        
        if(fcVal == JFileChooser.APPROVE_OPTION){
            file = FC.getSelectedFile();
        
            try (Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(FC.getSelectedFile().getAbsolutePath()+".message"), "UTF-8"))) {
                out.write(Key);
            } catch (IOException ex) {
                Logger.getLogger(OTPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SaveMessageMenuOptionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OTPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OTPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OTPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OTPFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OTPFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AlphabetButton;
    private javax.swing.JButton DecryptButton;
    private javax.swing.JButton EncryptButton;
    private javax.swing.JRadioButton NumericButton;
    private javax.swing.JMenuItem OpenKeyMenuOption;
    private javax.swing.JMenuItem OpenMessageMenuOption;
    private javax.swing.JMenuItem SaveKeyMenuOption;
    private javax.swing.JMenuItem SaveMessageMenuOption;
    private javax.swing.JRadioButton UnicodeButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea keyText;
    private javax.swing.JTextArea plainText;
    // End of variables declaration//GEN-END:variables
}
