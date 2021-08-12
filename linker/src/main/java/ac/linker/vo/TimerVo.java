package ac.linker.vo;

public class TimerVo {
    private int timerId;

    private String timerUser;
    private String timerRoom;

    private String timerSubject;
    private int timerStudyTime;

    public int getTimerId() {
        return this.timerId;
    }

    public void setTimerId(int timerId) {
        this.timerId = timerId;
    }

    public String getTimerUser() {
        return this.timerUser;
    }

    public void setTimerUser(String timerUser) {
        this.timerUser = timerUser;
    }

    public String getTimerRoom() {
        return this.timerRoom;
    }

    public void setTimerRoom(String timerRoom) {
        this.timerRoom = timerRoom;
    }

    public String getTimerSubject() {
        return this.timerSubject;
    }

    public void setTimerSubject(String timerSubject) {
        this.timerSubject = timerSubject;
    }

    public int getTimerStudyTime() {
        return this.timerStudyTime;
    }

    public void setTimerStudyTime(int timerStudyTime) {
        this.timerStudyTime = timerStudyTime;
    }
}
