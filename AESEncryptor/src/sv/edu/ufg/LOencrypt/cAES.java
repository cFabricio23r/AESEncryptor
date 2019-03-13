/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.LOencrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author UFG
 */
public class cAES {
    
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static String sIV = "4e5Wa71fYoT7MFEX";
    private static IvParameterSpec IV;
    
    
    String textEncr="";
    String textDecr="";
    
    public void setKey(String mKey){
        MessageDigest sha = null;
        try {
            key = mKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key,"AES");
            
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } 
        
    }
    
    public AlgorithmParameterSpec setIV() {
		try {
			IV = new IvParameterSpec(sIV.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

    public String getTextEncr() {
        return textEncr;
    }

    public void setTextEncr(String textEncr) {
        this.textEncr = textEncr;
    }

    public String getTextDecr() {
        return textDecr;
    }

    public void setTextDecr(String textDecr) {
        this.textDecr = textDecr;
    }
    
    public void encrypt(String textoEncrypt, String secKey){
        try {
            setKey(secKey);
            setIV();
            Cipher vCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            vCipher.init(Cipher.ENCRYPT_MODE, secretKey, IV);
            byte[] CipherText = vCipher.doFinal(textoEncrypt.getBytes("UTF-8"));
            textEncr = Base64.getEncoder().encodeToString(CipherText);
        }
        catch (Exception e)
        {
            System.out.println("Error durante encriptacion: " + e.toString());
        }
    }
    
    public void decrypt(String textoDecrypt, String secKey){
        try {
            setKey(secKey);
            setIV();
            Cipher vCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            vCipher.init(Cipher.DECRYPT_MODE, secretKey, IV);
            textDecr = new String(vCipher.doFinal(Base64.getDecoder().decode(textoDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error durante decriptacion: " + e.toString());
        }
    }
    
}
