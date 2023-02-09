class House implements Controller {
    private boolean IsWork;
    protected Time OnTime;
    protected Time OffTime;

    public House(boolean isWork, Time onTime, Time offTime) {
        IsWork = isWork;
        OnTime = onTime;
        OffTime = offTime;
    }

    @Override
    public void onTime(Time onTime) {
        this.OnTime = onTime;
    }

    @Override
    public void offTime(Time offTime) {
        this.OffTime = offTime;
    }

    @Override
    public void ElementOn() {
        IsWork = true;
    }

    @Override
    public void ElementOff() {
        IsWork = false;
    }

    public boolean isActive() {
        return IsWork;
    }

    public boolean isWithinWorkingHours(Time inputTime) {
        if(this.isActive() && inputTime.getHours() > OffTime.getHours()){
            return true;
        } else if (inputTime.getHours() > OnTime.getHours() && inputTime.getHours() < OffTime.getHours()) {
            return true;
        } else if (inputTime.getHours() == OnTime.getHours() && inputTime.getMinutes() >= OnTime.getMinutes()) {
            return true;
        } else if (inputTime.getHours() == OffTime.getHours() && inputTime.getMinutes() < OffTime.getMinutes()) {
            return true;
        }
        return false;
    }
}
