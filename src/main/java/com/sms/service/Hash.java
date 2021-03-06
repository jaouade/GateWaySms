package com.sms.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Hash {
    public class sha256 {
        public String hash(String textToHash)  {

            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(textToHash.getBytes());

            byte byteData[] = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte aByteData : byteData) {
                String hex = Integer.toHexString(0xff & aByteData);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }


    }
}
