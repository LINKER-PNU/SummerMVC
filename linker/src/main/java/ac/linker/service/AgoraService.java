package ac.linker.service;

import java.util.List;
import java.util.Map;

import ac.linker.dto.RoomDto;

public interface AgoraService {
    List<Map<String, Object>> getAgoraToken(RoomDto room);

    void updateAgoraToken(RoomDto room);

    List<Map<String, Object>> getAgoraUid(RoomDto room);

    void updateAgoraUid(RoomDto room);

    void resetAgora(RoomDto room);
}
