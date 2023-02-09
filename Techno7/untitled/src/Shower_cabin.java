class Shower_cabin extends House{
    private int Temperature;

    private boolean HydroMassage;

    public Shower_cabin(boolean isWork, Time onTime, Time offTime, int temperature, boolean hydroMassage) {
        super(isWork, onTime, offTime);
        Temperature = temperature;
        HydroMassage = hydroMassage;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    public boolean isHydroMassage() {
        return HydroMassage;
    }

    public void OnHydroMassage() {
        HydroMassage = true;
    }

    public void OffHydroMassage() {
        HydroMassage = false;
    }

    @Override
    public String toString() {
        return "Shower_cabin{" +
                (isActive() == true? "Condition=" + (isActive() == true? "working":"no working") +
                        ", OnTime=" +  OnTime.getTime() +
                        ", OffTime=" + OffTime.getTime() +
                        ", Temperature=" + Temperature +
                        ", HydroMassage=" + HydroMassage:
                        "Condition=" + (isActive() == true? "working":"no working") +
                                ", OnTime=" +  OnTime.getTime() +
                                ", OffTime=" + OffTime.getTime()
                ) +
                '}';

    }
}
