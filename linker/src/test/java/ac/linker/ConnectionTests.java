package ac.linker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;
import ac.linker.service.CodeGenerator;
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
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");
        try {
            RtcTokenBuilderSample.RtcTokenBuilderSampleMethod();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
