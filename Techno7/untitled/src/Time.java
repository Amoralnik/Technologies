class Time {
    private int hours;

    private int minutes;

    public Time(int hours, int minutes)
    {
        this.minutes = minutes;
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getTime() {
        return hours + ":" + minutes;
    }


}
