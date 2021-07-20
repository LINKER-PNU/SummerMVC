package ac.linker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac.linker.service.ConnectService;

@SpringBootTest
public class ConnectionTests {
    private ConnectService connectService;

    @Autowired
    ConnectionTests(ConnectService connectService){
        this.connectService = connectService;
    }

    @Test
    public void test(){
        System.out.println("############test############");
        System.out.println(connectService.getUser());
    }
}
