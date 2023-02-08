class Conditioner extends House{
    private int Temperature;
    public Conditioner(boolean isWork, Time onTime, Time offTime, int temperature) {
        super(isWork, onTime, offTime);
        Temperature = temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    @Override
    public String toString() {
        return "Conditioner {" +
                (isActive() == true? "Condition=" + (isActive() == true? "working":"no working") +
                        ", OnTime=" +  OnTime.getTime() +
                        ", OffTime=" + OffTime.getTime() +
                        ", Temperature=" + Temperature:
                        "Condition=" + (isActive() == true? "working":"no working") +
                                ", OnTime=" +  OnTime.getTime() +
                                ", OffTime=" + OffTime.getTime()) +
                '}';
    }
}
