package org.example.installerbyspringboot.Utils;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Calculator {
    private final Resource resource;
    private final String hash_algorithm ;
    public MD5Calculator(Resource resource,String hash_algorithm) {
        this.resource = resource;
        this.hash_algorithm = hash_algorithm;
    }
    //convert
    private static String bytesToHex(byte[] bytes){
        StringBuilder hexString = new StringBuilder();
        for(byte b:bytes){
            String hex = Integer.toHexString(0XFF & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public String getFileHash() throws IOException, NoSuchAlgorithmException {
        try(InputStream is = resource.getInputStream()){
            MessageDigest md = MessageDigest.getInstance(hash_algorithm);
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
            }
            byte[] hashBytes = md.digest();
            return bytesToHex(hashBytes);
        }
    }

}
