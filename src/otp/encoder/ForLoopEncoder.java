/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otp.encoder;

import javax.swing.JOptionPane;

/**
 * @author Sir_Kibble
 * Implementation of the OTP algorithm via for loops and charat()
 * v1.1 enabled enum for encoding options eliminating possible 
 * errors when specifying encoding types
 */
public class ForLoopEncoder implements Encoder{
    
    //objects vars
    //private String plainText,encodedText;
    private int characterSetSize, unicodeOffset;
    
    public ForLoopEncoder(){
        this.characterSetSize = 0;
        this.unicodeOffset = 0;
    }//end default constructor

    @Override
    public String encode(String plainText, String key, EncypherType type) {
        int n = -1;
        //checking key length before encoding
        if(plainText.length() > key.length()){
            //custom buttons
            Object[] options = {"Continue with message loss", "Go back"};
            n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The key is too short\n" +
                "to encode the entire message!  ",
                "WARNING!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
            );
        }//end if
        
        //break if user doesn't want incomplete encoding.
        if(n == 1)
            return plainText;
        
        String finalOutput = "";
        
        //verifying input strings.  Unicode needs no verification if it falls
        //within Character set limits, vustom buttons
        Object[] options = {"Yes, continue with encoding", "Go back"};
        if(type != EncypherType.unicode){
            if(!verifyString(plainText, type))
                n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The message has a character unsuitable\n"
                        + "for the encoding-type selected!  \n\n"
                        + "Is the correct radiobutton selected?",
                "Improper encoding detected!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
                );
            if(n==1)
                return plainText;
            if(!verifyString(key, type))
                n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The key has a character unsuitable\n"
                        + "for the encoding-type selected!  \n\n"
                        + "Is the correct radiobutton selected?",
                "Improper encoding detected!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
                );
            if(n==1)
                return plainText;
        }//end verification
        setEncypher(type);
        for(int x = 0; x < key.length() && x < plainText.length(); x++){
            //if(x == 100)break;//remember to remove this!!!
            int temp = key.charAt(x);
            int temp2 = plainText.charAt(x);
            finalOutput += (char)((((key.charAt(x) - unicodeOffset) + (plainText.charAt(x) - unicodeOffset)) % characterSetSize) + unicodeOffset);
        }//end for modulator       
        return finalOutput;
    }//end encode

    @Override
    public String decode(String encodedText, String key, EncypherType type) {
        int n = -1;
        //checking key length before decoding
        if(encodedText.length() > key.length()){
            //Custom button text
            Object[] options = {"Continue with message loss", "Go back"};
                n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The key is too short\n" +
                "to decode the entire message!  ",
                "WARNING!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
            );
        }//end if
        
        //break if user doesn't want incomplete encoding.
        if(n == 1)
            return encodedText;
        
        //verifying input strings.  Unicode needs no verification if it falls
        //within Character set limits, vustom buttons
        Object[] options = {"Yes, continue with decoding", "Go back"};
        if(type != EncypherType.unicode){
            if(!verifyString(encodedText, type))
                n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The message has a character unsuitable\n"
                        + "for the decoding-type selected!  \n\n"
                        + "Is the correct radiobutton selected?",
                "Improper decoding detected!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
                );
            if(n==1)
                return encodedText;
            if(!verifyString(key, type))
                n = JOptionPane.showOptionDialog(
                    null,
                "WARNING!  The key has a character unsuitable\n"
                        + "for the decoding-type selected!  \n\n"
                        + "Is the correct radiobutton selected?",
                "Improper decoding detected!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
                );
            if(n==1)
                return encodedText;
        }//end verification
        
        setEncypher(type);
        String finalOutput = "";
        for(int x = 0; x < key.length() && x < encodedText.length(); x++){
            int temp = ((encodedText.charAt(x) - unicodeOffset) - (key.charAt(x) - unicodeOffset)) % characterSetSize;
            if(temp < 0){//w = 22 v = 21 u = 20 y = 24
                temp += characterSetSize;
            }//end if
            finalOutput += (char)(temp + unicodeOffset);
        }//end for modulator       
        return finalOutput;
    }//end decode

    private void setEncypher (EncypherType type){
        if(null != type)switch (type) {
            case alphabet:
                this.characterSetSize = 26;
                this.unicodeOffset = 97;
                break;
            case numeric:
                this.characterSetSize = 10;
                this.unicodeOffset = 48;
                break;
            case unicode:
                this.characterSetSize = 1114112;
                this.unicodeOffset = 0;
                break;
            default:
                //throw new Exception e;
                break;
        }
    }
    
    /**
     * @param 
     * @return 
     * verifyString ensures that the string supplied correctly matches the 
     * encypher type based on the offsets and character sets as per unicode
     */ 
    private boolean verifyString(String input, EncypherType type){
        char[] temp = input.toCharArray();
        if(type == EncypherType.numeric){
            for(int c : temp/*input.toCharArray()*/)
                if(c - 48 > 10)
                    return false;
        }//end if numeric message verification
        else if(type == EncypherType.alphabet){
            for(int c : temp/*input.toCharArray()*/)
                if(c - 97 < 0 || c - 97 > 26)
                    return false;
        }//end if alphabet message verification        
        //everything checks out, so return true
        return true;
    }//end verifyString
}
