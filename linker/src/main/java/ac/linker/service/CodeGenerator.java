package ac.linker.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CodeGenerator {
    private static final String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static String base62Encode(int text) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = text % 62;
            sb.append(base.charAt(i));
            text /= 62;
        } while (text > 0);

        return sb.toString();
    }
    
    public static String getCode(int index){
        SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		
        final String time = format.format(new Date());
		
        String indexStr = Integer.toString(index);

        final StringBuilder sb = new StringBuilder();

        sb.append(time);
        for(int i = 0; i < 4 - indexStr.length(); i++){
            sb.append('0');
        }
        sb.append(indexStr);

        indexStr = sb.toString();

        final String cipher = base62Encode(Integer.parseInt(indexStr));

        System.out.println(indexStr + " => " + cipher + "\n");
        
        return cipher;
    } 
}
