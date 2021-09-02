package ac.linker.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.mapper.ConnectMapper;
import ac.linker.service.ConnectService;

@Service
public class ConnectServiceImplement implements ConnectService {
    private ConnectMapper connectMapper;

    @Autowired
    ConnectServiceImplement(ConnectMapper connectMapper) {
        this.connectMapper = connectMapper;
    }

    public List<Map<String, Object>> getRoomByCode(RoomDto room) {
        return connectMapper.getRoomByCode(room);
    }

    public List<Map<String, Object>> getCodeByName(RoomDto room) {
        return connectMapper.getCodeByName(room);
    }

    public List<Map<String, Object>> findRoom(RoomDto room) {
        return connectMapper.findRoom(room);
    }

    public void insertRoom(RoomDto room) {
        connectMapper.insertRoom(room);
    }

    public void insertJoin(JoinDto join) {
        connectMapper.insertJoin(join);
    }

    public void updateRoomCode(RoomDto room) {
        connectMapper.updateRoomCode(room);
    }

    public void updateRoomJoin(JoinDto join) {
        connectMapper.updateRoomJoin(join);
    }

    public void updateRoomNewJoin(JoinDto join) {
        connectMapper.updateRoomNewJoin(join);
    }

    public void updateRoomLeave(RoomDto room) {
        connectMapper.updateRoomLeave(room);
    }

    public Map<String, Object> getRoomPresent(RoomDto room) {
        return connectMapper.getRoomPresent(room);
    }
}
