package ac.linker.service;

import org.springframework.stereotype.Service;

@Service
public class CodeGenerator {
    static final String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private String base62Encode(int text) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = text % 62;
            sb.append(base.charAt(i));
            text /= 62;
        } while (text > 0);

        return sb.toString();
    }
    
    public static String getCode(void){
        
    } 
}
