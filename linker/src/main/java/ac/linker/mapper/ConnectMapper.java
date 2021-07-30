package ac.linker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.dto.UserDto;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ConnectMapper {
    List<Map<String, Object>> getAllUser();

    List<Map<String, Object>> getUser(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    List<Map<String, Object>> getRoomByCode(RoomDto room);

    List<Map<String, Object>> getCodeByName(RoomDto room);

    void insertUser(UserDto user);
    
    void insertRoom(RoomDto room);
    
    void insertJoin(JoinDto join);

    void updateToken(UserDto user);

    void updateRoomCode(RoomDto room);

    void updateRoomJoin(RoomDto room);

    void updateRoomNewJoin(RoomDto room);

    void updateRoomLeave(RoomDto room);
}
