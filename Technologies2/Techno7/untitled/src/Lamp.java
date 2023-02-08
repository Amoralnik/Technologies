class Lamp extends House{
    public Lamp(boolean isWork, Time onTime, Time offTime) {
        super(isWork, onTime, offTime);
    }

    @Override
    public String toString() {
        return "Lamp        {" +
                "Condition=" + (isActive() == true? "working":"no working")  +
                ", OnTime=" +  OnTime.getTime() +
                ", OffTime=" + OffTime.getTime() +
                "}";
    }
}
