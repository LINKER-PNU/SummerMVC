package ac.linker.dto;

public class TimerDto {
    private int timerId;

    private String timerUser;
    private String timerRoom;

    private String timerSubject;
    private int timerStudyTime;

    public void setTimerId(int timerId) {
        this.timerId = timerId;
    }

    public void setTimerUser(String timerUser) {
        this.timerUser = timerUser;
    }

    public void setTimerRoom(String timerRoom) {
        this.timerRoom = timerRoom;
    }

    public void setTimerSubject(String timerSubject) {
        this.timerSubject = timerSubject;
    }

    public void setTimerStudyTime(int timerStudyTime) {
        this.timerStudyTime = timerStudyTime;
    }

}
