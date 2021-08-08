package ac.linker.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.RoomDto;

@Repository
@Mapper
public interface AgoraMapper {
    List<Map<String, Object>> getAgoraToken(RoomDto room);

    void updateAgoraToken(RoomDto room);

    List<Map<String, Object>> getAgoraUid(RoomDto room);

    void updateAgoraUid(RoomDto room);

    void resetAgora(RoomDto room);
}
