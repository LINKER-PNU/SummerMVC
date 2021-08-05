package ac.linker.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;
import ac.linker.mapper.ConnectMapper;
import ac.linker.service.ConnectService;

@Service
public class ConnectServiceImplement implements ConnectService {
    private ConnectMapper connectMapper;

    @Autowired
    ConnectServiceImplement(ConnectMapper connectMapper) {
        this.connectMapper = connectMapper;
    }

    public List<Map<String, Object>> getAllUser() {
        return connectMapper.getAllUser();
    }

    public List<Map<String, Object>> getUser(UserDto user) {
        return connectMapper.getUser(user);
    }

    public List<Map<String, Object>> getSkin(UserDto user) {
        return connectMapper.getSkin(user);
    }

    public List<Map<String, Object>> getRoom(UserDto user) {
        return connectMapper.getRoom(user);
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

    public List<Map<String, Object>> getUserByName(UserDto user) {
        return connectMapper.getUserByName(user);
    }

    public List<Map<String, Object>> getRoomByName(UserDto user) {
        return connectMapper.getRoomByName(user);
    }

    public void insertUser(UserDto user) {
        connectMapper.insertUser(user);
    }

    public void insertRoom(RoomDto room) {
        connectMapper.insertRoom(room);
    }

    public void insertJoin(JoinDto join) {
        connectMapper.insertJoin(join);
    }

    public void updateToken(UserDto user) {
        connectMapper.updateToken(user);
    }

    public void updateRoomCode(RoomDto room) {
        connectMapper.updateRoomCode(room);
    }

    public void updateRoomJoin(RoomDto room) {
        connectMapper.updateRoomJoin(room);
    }

    public void updateRoomNewJoin(RoomDto room) {
        connectMapper.updateRoomNewJoin(room);
    }

    public void updateRoomLeave(RoomDto room) {
        connectMapper.updateRoomLeave(room);
    }

    public List<Map<String, Object>> getAgoraToken(RoomDto room){
        return connectMapper.getAgoraToken(room);
    }

    public void updateAgoraToken(RoomDto room){
        connectMapper.updateAgoraToken(room);
    }

    public List<Map<String, Object>> getAgoraUid(RoomDto room){
        return connectMapper.getAgoraUid(room);
    }

    public void updateAgoraUid(RoomDto room){
        connectMapper.updateAgoraUid(room);
    }

    public void resetAgora(RoomDto room){
        connectMapper.resetAgora(room);
    }
}
