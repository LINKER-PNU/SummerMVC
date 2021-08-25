package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.UserDto;

public interface HomeService {

    void insertUser(UserDto user);

    void updateToken(UserDto user);

    void updateSkinColor(UserDto user);

    void updateSkinCloth(UserDto user);

    List<Map<String, Object>> getAllUser();

    Map<String, Object> getUser(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    List<Map<String, Object>> getUserByName(UserDto user);

    List<Map<String, Object>> getRoomByName(UserDto user);
}
