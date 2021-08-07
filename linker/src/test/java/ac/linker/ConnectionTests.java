package ac.linker;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.dto.RoomDto;
import ac.linker.service.AgoraService;
import ac.linker.service.ConnectService;
import ac.linker.service.HomeService;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;
    private AgoraService agoraService;
    private HomeService homeService;

    @Autowired
    ConnectionTests(ConnectService connectService, AgoraService agoraService, HomeService homeService) {
        this.connectService = connectService;
        this.agoraService = agoraService;
        this.homeService = homeService;
    }

    @Test
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");
        System.out.println(homeService.getAllUser());
    }
}