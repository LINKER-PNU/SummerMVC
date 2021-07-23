package ac.linker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.UserDto;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ConnectMapper {
    List<Map<String, Object>> getUser();
    void insertUser(UserDto user);
}
