package ac.linker.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.RoomDto;
import ac.linker.mapper.AgoraMapper;
import ac.linker.service.AgoraService;

@Service
public class AgoraServiceImplement implements AgoraService {
    private AgoraMapper agoraMapper;

    @Autowired
    AgoraServiceImplement(AgoraMapper agoraMapper) {
        this.agoraMapper = agoraMapper;
    }

    public List<Map<String, Object>> getAgoraToken(RoomDto room) {
        return agoraMapper.getAgoraToken(room);
    }

    public void updateAgoraToken(RoomDto room) {
        agoraMapper.updateAgoraToken(room);
    }

    public List<Map<String, Object>> getAgoraUid(RoomDto room) {
        return agoraMapper.getAgoraUid(room);
    }

    public void updateAgoraUid(RoomDto room) {
        agoraMapper.updateAgoraUid(room);
    }

    public void resetAgora(RoomDto room) {
        agoraMapper.resetAgora(room);
    }
}
