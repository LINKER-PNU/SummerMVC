package ac.linker.controller;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.linker.dto.TimerDto;
import ac.linker.service.ResponseService;
import ac.linker.service.TimerService;
import ac.linker.vo.TimerVo;

@RequestMapping(value = "/timer")
public class TimerController {
    private TimerService timerService;
    private ResponseService responseService;

    private Gson gson = new Gson();
    private ModelMapper modelMapper = new ModelMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TimerController(TimerService timerService, ResponseService responseService) {
        this.timerService = timerService;
        this.responseService = responseService;
    }

    // add timer
    @PostMapping(value = "/add", produces = "application/json; charset=utf8")
    public String addTimer(@RequestBody TimerVo timerVo) {
        logger.info("addTimer :: " + timerVo.getTimerRoom() + " :: " + timerVo.getTimerUser() + " :: " + timerVo.getTimerSubject());
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);

        timerService.insertTimer(timerDto);

        logger.info("Timer subject insert complete.\n");
        return responseService.getResultResponse(true);
    }

    // get timer list
    @PostMapping(value = "/list", produces = "application/json; charset=utf8")
    public String getTimers(@RequestBody TimerVo timerVo) {
        logger.info("getTimers :: " + timerVo.getTimerRoom() + " :: " + timerVo.getTimerId());
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);

        final String timers = gson.toJson(timerService.getTimers(timerDto));
        logger.info("Timers select complete.\n");
        return timers;
    }

    // click stop button
    @PostMapping(value = "/stop", produces = "application/json; charset=utf8")
    public String stopTimer(@RequestBody TimerVo timerVo) {
        logger.info("stopTimer :: " + timerVo.getTimerId());
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);

        timerService.accumTimer(timerDto);
        logger.info("Timer stopped and update complete.\n");

        return responseService.getResultResponse(true);
    }

    // edit timer
    @PostMapping(value = "/edit", produces = "application/json; charset=utf8")
    public String editTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);
        logger.info("editTimer :: " + timerVo.getTimerId());

        timerService.editTimer(timerDto);
        logger.info("Timer subject edit complete.\n");

        return responseService.getResultResponse(true);
    }

    // delete timer
    @PostMapping(value = "/remove", produces = "application/json; charset=utf8")
    public String removeTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);
        logger.info("removeTimer :: " + timerVo.getTimerId());

        timerService.deleteTimer(timerDto);
        logger.info("Timer delete complete.\n");

        return responseService.getResultResponse(true);
    }
}
