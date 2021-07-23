package ac.linker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;

@SpringBootTest
public class ConnectionTests {
    private ConnectService connectService;

    @Autowired
    ConnectionTests(ConnectService connectService) {
        this.connectService = connectService;
    }

    @Test
    public void getUserTest() {
        System.out.println("############getUserTest############");
        System.out.println(connectService.getUser());
    }

    @Test
    public void insertUserTest(){
        System.out.println("############insertUserTest############");
        connectService.insertUser(new UserDto("authToken1", "displayName2", "userId3"));
    }

}
