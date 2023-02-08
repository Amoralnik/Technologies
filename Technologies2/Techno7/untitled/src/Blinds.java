class Blinds extends House{
    public Blinds(boolean isWork, Time onTime, Time offTime) {
        super(isWork, onTime, offTime);
    }

    @Override
    public String toString() {
        return "Blinds      {"+
                "Condition=" + (isActive() == true? "working":"no working")  +
                ", OnTime=" +  OnTime.getTime() +
                ", OffTime=" + OffTime.getTime() +
                "}";
    }
}
