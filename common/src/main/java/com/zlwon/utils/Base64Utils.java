package com.zlwon.utils;

import java.io.*;
import java.util.Base64;

public class Base64Utils {

	/**  
     * 将本地图片进行Base64位编码  
     * @param imgUrl 图片的url路径，如d:\\中文.jpg  
     * @return  
     */    
    public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理    
        
    	// 其进行Base64编码处理    
        byte[] data = null;    
        // 读取图片字节数组    
        try {    
            InputStream in = new FileInputStream(imageFile);    
            data = new byte[in.available()];    
            in.read(data);    
            in.close();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        
        // 对字节数组Base64编码    
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedText = encoder.encodeToString(data);
        return encodedText;// 返回Base64编码过的字节数组字符串    
    }    
}
