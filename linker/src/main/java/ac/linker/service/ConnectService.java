package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.UserDto;

public interface ConnectService {
    List<Map<String,Object>> getUser();
    void insertUser(UserDto user);
    void updateToken(UserDto user);
}
