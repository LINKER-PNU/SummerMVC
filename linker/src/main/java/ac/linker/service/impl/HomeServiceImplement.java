package ac.linker.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.UserDto;
import ac.linker.mapper.HomeMapper;
import ac.linker.service.HomeService;

@Service
public class HomeServiceImplement implements HomeService {
    private HomeMapper homeMapper;

    @Autowired
    HomeServiceImplement(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    public void insertUser(UserDto user) {
        homeMapper.insertUser(user);
    }

    public void updateToken(UserDto user) {
        homeMapper.updateToken(user);
    }

    public void updateSkin(UserDto user) {
        homeMapper.updateSkin(user);
    }

    public List<Map<String, Object>> getAllUser() {
        return homeMapper.getAllUser();
    }

    public List<Map<String, Object>> getUser(UserDto user) {
        return homeMapper.getUser(user);
    }

    public List<Map<String, Object>> getSkin(UserDto user) {
        return homeMapper.getSkin(user);
    }

    public List<Map<String, Object>> getRoom(UserDto user) {
        return homeMapper.getRoom(user);
    }

    public List<Map<String, Object>> getUserByName(UserDto user) {
        return homeMapper.getUserByName(user);
    }

    public List<Map<String, Object>> getRoomByName(UserDto user) {
        return homeMapper.getRoomByName(user);
    }

}
