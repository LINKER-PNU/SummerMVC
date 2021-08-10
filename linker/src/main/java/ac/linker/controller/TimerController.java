package ac.linker.controller;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
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

    @Autowired
    TimerController(TimerService timerService, ResponseService responseService){
        this.timerService = timerService;
        this.responseService = responseService;
    }

    // add timer
    @PostMapping(value = "/add", produces = "application/json; charset=utf8")
    public String addTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo,TimerDto.class);

        timerService.insertTimer(timerDto);

        return responseService.getResultResponse(true);
    }

    // get timer list
    @PostMapping(value = "/list", produces = "application/json; charset=utf8")
    public String getTimers(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo, TimerDto.class);
        
        return gson.toJson(timerService.getTimers(timerDto));
    }

    // click stop button
    @PostMapping(value = "/stop", produces = "application/json; charset=utf8")
    public String stopTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo,TimerDto.class);

        timerService.accumTimer(timerDto);

        return responseService.getResultResponse(true);
    }

    // edit timer
    @PostMapping(value = "/edit", produces = "application/json; charset=utf8")
    public String editTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo,TimerDto.class);

        timerService.editTimer(timerDto);

        return responseService.getResultResponse(true);
    }

    // delete timer
    @PostMapping(value = "/remove", produces = "application/json; charset=utf8")
    public String removeTimer(@RequestBody TimerVo timerVo) {
        TimerDto timerDto = modelMapper.map(timerVo,TimerDto.class);

        timerService.deleteTimer(timerDto);

        return responseService.getResultResponse(true);
    }
}
