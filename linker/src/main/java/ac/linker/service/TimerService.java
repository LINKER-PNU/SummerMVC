package ac.linker.service;

import java.util.List;

import ac.linker.dto.TimerDto;
import ac.linker.vo.TimerVo;

public interface TimerService {
    List<TimerVo> getTimers(TimerDto timerDto);
    
    void insertTimer(TimerDto timerDto);

    void editTimer(TimerDto timerDto);

    void accumTimer(TimerDto timerDto);

    void deleteTimer(TimerDto timerDto);
}
