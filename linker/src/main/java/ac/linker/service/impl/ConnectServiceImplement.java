package ac.linker.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.mapper.ConnectMapper;
import ac.linker.service.ConnectService;

@Service
public class ConnectServiceImplement implements ConnectService{
    private ConnectMapper connectMapper;

    @Autowired
    ConnectServiceImplement(ConnectMapper connectMapper){
        this.connectMapper = connectMapper;
    }

    public List<Map<String,Object>> getUser(){
        return connectMapper.getUser();
    }
    
}
