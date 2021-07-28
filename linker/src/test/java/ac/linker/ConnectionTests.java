package ac.linker;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;

@SpringBootTest
public class ConnectionTests {
    private ConnectService connectService;

    @Autowired
    ConnectionTests(ConnectService connectService) {
        this.connectService = connectService;
    }

    // @Test
    // public void getUserTest() {
    //     System.out.println("############getUserTest############");
    //     System.out.println(connectService.getAllUser());
    // }

    // @Test
    // public void connectionTest(){
    //     System.out.println("############connectionTest############");
    //     List<Map<String,Object>> roomName = connectService.getRoomByCode(new RoomDto("", "aa", 0,0));

    //     if(roomName.size() > 0)
    //         System.out.println(roomName.get(0).get("room_name").toString());
    //     else
    //         System.out.println("not exist");
    // }

}
