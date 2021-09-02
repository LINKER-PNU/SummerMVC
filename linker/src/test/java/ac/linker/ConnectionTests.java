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

        RoomDto roomDto = new RoomDto("AAAAAAAAAAAAAAAAAAAAA");

        try {
            connectService.insertJoin(new JoinDto(null, "1"));
            connectService.updateRoomNewJoin(roomDto);
            logger.info("User {} recreated and joined in {}.\n");
        } catch (DuplicateKeyException e) {
            connectService.updateRoomJoin(roomDto);
            logger.info("User {} is already in room {}! Duplicated pair is prevented.\n");
        } catch (DataIntegrityViolationException s) {
            logger.error("User {} is not in table user! Joining room is failed.\n");

        }
    }
}