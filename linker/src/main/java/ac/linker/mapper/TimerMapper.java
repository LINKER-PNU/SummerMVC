package ac.linker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ac.linker.dto.TimerDto;
import ac.linker.vo.TimerVo;

@Repository
@Mapper
public interface TimerMapper {
    List<TimerVo> getTimers(TimerDto timerDto);

    void insertTimer(TimerDto timerDto);

    void editTimer(TimerDto timerDto);

    void accumTimer(TimerDto timerDto);

    void deleteTimer(TimerDto timerDto);
}
