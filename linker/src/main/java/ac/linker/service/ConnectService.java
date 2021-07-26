package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.UserDto;

public interface ConnectService {
    List<Map<String, Object>> getAllUser();

    List<Map<String, Object>> getUserName(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    void insertUser(UserDto user);

    void updateToken(UserDto user);
}
