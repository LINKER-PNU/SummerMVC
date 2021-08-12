package ac.linker.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.UserDto;

@Repository
@Mapper
public interface HomeMapper {

    void insertUser(UserDto user);

    void updateToken(UserDto user);

    void updateSkinColor(UserDto user);

    List<Map<String, Object>> getAllUser();

    List<Map<String, Object>> getUser(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    List<Map<String, Object>> getUserByName(UserDto user);

    List<Map<String, Object>> getRoomByName(UserDto user);
}
