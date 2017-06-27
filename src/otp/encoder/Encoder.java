/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otp.encoder;

/**
 *
 * @author minimole2
 */
public interface Encoder {

    /**
     * Encodings specify what type of encyphering/decyphering will be done.  
     * numeric encyphers numbers only
     * alphabet encyphers lowercase english characters only
     * unicode encyphers on the unicode character set
     */
    public enum EncypherType{numeric,alphabet,unicode};
    /**
     * @param key
     * @param plainText
     * @param type
     * @return 
     * handles the encrypting of OTP encrypted text
     *
     */
    public String encode(String plainText, String key, EncypherType type);
    /**
     * @param key
     * @param encodedText 
     * @param type 
     * @return  
     * handles the decoding of OTP encrypted text
     */
    public String decode(String encodedText, String key, EncypherType type);
    
    /** @deprecated 
     *  USE SetEncypher for enum stability
     * @param options
     * allows for the input of an integer to the encoder.  
     * Unless otherwise stated, the option controls the modululating 
     * operation for encoding and decoding OTP.
     * 
     * 26 - singlecase alphabet
     * 1114112 - all possible unicode characters
     */
    //public void setOptions(int option1, int option2);
    
    /**@deprecated 
     */
    //public void setEncypher(EncypherType type);
}
