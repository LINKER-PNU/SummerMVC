package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;

public interface ConnectService {
    List<Map<String, Object>> getAllUser();

    List<Map<String, Object>> getUser(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    List<Map<String, Object>> getRoomByCode(RoomDto room);

    List<Map<String, Object>> getCodeByName(RoomDto room);

    List<Map<String, Object>> findRoom(RoomDto room);

    List<Map<String, Object>> getUserByName(UserDto user);

    List<Map<String, Object>> getRoomByName(UserDto user);

    void insertUser(UserDto user);

    void insertRoom(RoomDto room);

    void insertJoin(JoinDto join);

    void updateToken(UserDto user);

    void updateRoomCode(RoomDto room);

    void updateRoomJoin(RoomDto room);

    void updateRoomNewJoin(RoomDto room);

    void updateRoomLeave(RoomDto room);

    List<Map<String, Object>> getAgoraToken(RoomDto room);

    void updateAgoraToken(RoomDto room);

    List<Map<String, Object>> getAgoraUid(RoomDto room);

    void updateAgoraUid(RoomDto room);

    void resetAgora(RoomDto room);

    void updateSkin(UserDto user);
}
