package ac.linker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.catalina.startup.HomesUserDatabase;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import ac.linker.dto.BoardDto;
import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.TimerDto;
import ac.linker.dto.UserDto;
import ac.linker.service.AgoraService;
import ac.linker.service.BoardService;
import ac.linker.service.ConnectService;
import ac.linker.service.HomeService;
import ac.linker.service.ResponseService;
import ac.linker.service.TimerService;
import ac.linker.vo.BoardVo;
import ac.linker.vo.UserVo;

@SpringBootTest
public class ConnectionTests {
    private Gson gson = new Gson();
    private ConnectService connectService;
    private AgoraService agoraService;
    private HomeService homeService;
    private BoardService boardService;
    private TimerService timerService;
    private ResponseService responseService;

    ModelMapper modelMapper = new ModelMapper();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Marker marker;

    @Autowired
    ConnectionTests(ConnectService connectService, AgoraService agoraService, HomeService homeService,
            BoardService boardService, TimerService timerService, ResponseService responseService) {
        this.connectService = connectService;
        this.agoraService = agoraService;
        this.homeService = homeService;
        this.boardService = boardService;
        this.timerService = timerService;
        this.responseService = responseService;
    }

    @Test
    public void connectionTest() {
        System.out.println("###############ConnectionTest##############");

        final JoinDto joinDto = new JoinDto("id", "2"); // 1 2 5 10 15 new 5 2

        try {
            connectService.insertJoin(joinDto);
            connectService.updateRoomNewJoin(joinDto);
            connectService.updateJoiningRecentDt(joinDto);
        } catch (DuplicateKeyException e) {
            System.out.println("x");
            connectService.updateRoomJoin(joinDto);
            connectService.updateJoiningRecentDt(joinDto);
        } catch (DataIntegrityViolationException s) {
            System.out.println("a");
        }
    }
}