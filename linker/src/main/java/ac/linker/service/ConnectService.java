package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;

public interface ConnectService {
    List<Map<String, Object>> getRoomByCode(RoomDto room);

    List<Map<String, Object>> getCodeByName(RoomDto room);

    List<Map<String, Object>> findRoom(RoomDto room);

    void insertRoom(RoomDto room);

    void insertJoin(JoinDto join);

    void updateRoomCode(RoomDto room);

    void updateRoomJoin(RoomDto room);

    void updateRoomNewJoin(RoomDto room);

    void updateRoomLeave(RoomDto room);

    Map<String, Object> getRoomPresent(RoomDto room);
}
