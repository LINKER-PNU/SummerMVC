package ac.linker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.linker.dto.TimerDto;
import ac.linker.mapper.TimerMapper;
import ac.linker.service.TimerService;
import ac.linker.vo.TimerVo;

@Service
public class TimerServiceImplement implements TimerService {
    private TimerMapper timerMapper;

    @Autowired
    TimerServiceImplement(TimerMapper timerMapper) {
        this.timerMapper = timerMapper;
    }

    public List<TimerVo> getTimers(TimerDto timerDto) {
        return timerMapper.getTimers(timerDto);
    }

    public void insertTimer(TimerDto timerDto) {
        timerMapper.insertTimer(timerDto);
    }

    public void editTimer(TimerDto timerDto) {
        timerMapper.editTimer(timerDto);
    }

    public void accumTimer(TimerDto timerDto) {
        timerMapper.accumTimer(timerDto);
    }

    public void deleteTimer(TimerDto timerDto) {
        timerMapper.deleteTimer(timerDto);
    }

}
