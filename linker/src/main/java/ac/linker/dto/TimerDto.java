package ac.linker.dto;

public class TimerDto {
    private int timerId;

    private String timerUser;
    private String timerRoom;

    private String timerSubject;
    private int timerStudyTime;

    public TimerDto(int timerId, String timerUser, String timerRoom, String timerSubject, int timerStudyTime) {
        this.timerId = timerId;
        this.timerUser = timerUser;
        this.timerRoom = timerRoom;
        this.timerSubject = timerSubject;
        this.timerStudyTime = timerStudyTime;
    }
}
