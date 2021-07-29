package ac.linker;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;

    @Autowired
    ConnectionTests(ConnectService connectService) {
        this.connectService = connectService;
    }

    @Test
    public void connectionTest(){
        System.out.println("############connectionTest############");
        JsonObject userInfo = new JsonObject();

        UserDto user = new UserDto("authToken", "displayName", "user_id1");

        List<Map<String, Object>> userNameResult = connectService.getUserName(user);

        JsonObject jsonString = gson.toJsonTree(userNameResult.get(0)).getAsJsonObject();

        userInfo.add("property", jsonString);

        

        System.out.println(userInfo.getAsJsonObject("property").get("user_name").getAsString());

    }
}
