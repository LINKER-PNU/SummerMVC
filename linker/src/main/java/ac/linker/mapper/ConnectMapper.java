package ac.linker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.UserDto;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ConnectMapper {
    List<Map<String, Object>> getAllUser();

    List<Map<String, Object>> getUserName(UserDto user);

    List<Map<String, Object>> getSkin(UserDto user);

    List<Map<String, Object>> getRoom(UserDto user);

    void insertUser(UserDto user);

    void updateToken(UserDto user);
}
