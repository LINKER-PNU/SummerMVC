package ac.linker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import ac.linker.controller.ConnectController;
import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;
import ac.linker.service.CodeGenerator;
import ac.linker.service.ConnectService;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;
    static int i = 92645;
    @Autowired
    ConnectionTests(ConnectService connectService) {
        this.connectService = connectService;
    }

    @Test
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");
        // try {
        //     RtcTokenBuilderSample.RtcTokenBuilderSampleMethod();    
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }
        
        System.out.println(i);
    }
}