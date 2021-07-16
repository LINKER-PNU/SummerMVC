package ac.linker.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.stereotype.Service;


@Service
public class KakaoAPI {
    
    public String getAccessToken(String authCode){
        String accessToken = "";
        String refreshToken = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            
            // setDoOutput(true) for POST request
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // write required parameter and send by stream
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=e11e4590940d34ea0439839fd74a56f4");
            sb.append("&redirect_uri=http://localhost:8080/login");
            sb.append("&code=" + authCode);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("API::responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null){
                result += line;
            }

            System.out.println("API::response body : " + result);

            JsonObject element = JsonParser.parseString(result).getAsJsonObject();

            accessToken = element.get("access_token").getAsString();
            refreshToken = element.get("refresh_token").getAsString();

            System.out.println("API::access_token : " + accessToken);
            System.out.println("API::refresh_token : " + refreshToken);

            br.close();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return accessToken;
    }
}
