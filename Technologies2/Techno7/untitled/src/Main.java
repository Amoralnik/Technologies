import javax.management.InvalidAttributeValueException;
import java.io.*;
import java.security.InvalidKeyException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, InvalidKeyException {
        //make a list of starter pack house objects
        List<House> objects = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int changeable = 0;
        int changeable2 = 0;
        CreateStarterPack(objects);
        Menu1(objects);
    }

    private static void Menu1(List<House> objects) throws IOException, InvalidKeyException {

        Scanner s = new Scanner(System.in);
        int changeable = 0;
        int changeable2 = 0;
        System.out.println("\nNext move:\n1.Add new object\n2.Delete object\n" +
                "3.Change condition of object\n4.Working at user time\nelse.EXIT");
        changeable = s.nextInt();
        try {
            switch (changeable) {
                case 1:
                    CreateNewObject(objects);
                    break;
                case 2:
                    System.out.print("Which one :");
                    changeable2 = s.nextInt();
                    if (changeable2 >= objects.size())
                        throw new IllegalArgumentException("Illegal argument of list: " + changeable2);
                    objects.remove(changeable2-1);
                    break;
                case 3:
                    System.out.print("Which one :");
                    changeable2 = s.nextInt();
                    if (changeable2 > objects.size())
                        throw new IllegalArgumentException("Illegal argument of list: " + changeable2);
                    ChangeObject(objects,changeable2 - 1);
                    break;
                case 4:
                    Time time1 = new Time(0,0);
                    System.out.println("Time(int int): ");
                    time1.setHours(s.nextInt());
                    if (time1.getHours() > 23)
                        throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                    time1.setMinutes(s.nextInt());
                    if (time1.getMinutes() > 59)
                        throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());

                    List<House> Filtered_Objects = objects.stream()
                            .filter(house -> house.isWithinWorkingHours(time1))
                            .collect(Collectors.toList());

                    System.out.println();
                    int i = 1;
                    for (House object : Filtered_Objects) {
                        System.out.println(i++ + ": " + object);
                    }
                    Filtered_Objects.clear();
                    Menu1(objects);
                default:
                    System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.err.println("Error:" + e.getMessage());
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        System.out.println();
        for (House object : objects) {
            System.out.println(i++ + ": " + object);
        }
        Menu1(objects);
    }

    private static void ChangeObject(List<House> objects, int num) throws IOException {
        House object = objects.get(num);
        int changeable;
        Scanner s = new Scanner(System.in);
        Time time1 = new Time(0, 0);
        /*
        System.out.println("\nWhat type:\n1.Fridge\n2.Blinds\n3.Lamp\n4.Conditioner\n5.Shower_cabin");

        changeable = s.nextInt();
        House house = null;
        boolean active;
        int Temperature;
        boolean Shower;
        Time time1 = new Time(0,0);
        Time time2 = new Time(0,0);

        switch (changeable)
        {
            case 1:
                System.out.println("Change: 1.Temperature\n2.Change condition\n3.Time On\n4.Time Off\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable){
                    case 1:
                        System.out.print("Temperature: ");

                }

        }

         */

        try {
            if (object instanceof Fridge) {
                System.out.println("\nChange: \n1.Change condition\n2.Time On\n3.Time Off\n4.Temperature\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable) {
                    case 1:
                        if (object.isActive())
                            object.ElementOff();
                        else
                            object.ElementOn();
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 2:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hors value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.onTime(time1);
                        break;
                    case 3:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hors value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.offTime(time1);
                        break;
                    case 4:
                        System.out.print("Temperature: ");
                        ((Fridge) object).setTemperature(s.nextInt());
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    default:
                        //Menu1(objects);
                        break;

                }
            } else if (object instanceof Blinds) {
                System.out.println("\nChange: \n1.Change condition\n2.Time On\n3.Time Off\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable) {
                    case 1:
                        if (object.isActive())
                            object.ElementOff();
                        else
                            object.ElementOn();
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 2:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.onTime(time1);
                        break;
                    case 3:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.offTime(time1);
                        break;
                    default:
                        //Menu1(objects);
                        break;

                }
            } else if (object instanceof Lamp) {
                System.out.println("\nChange: \n1.Change condition\n2.Time On\n3.Time Off\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable) {
                    case 1:
                        if (object.isActive())
                            object.ElementOff();
                        else
                            object.ElementOn();
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 2:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.onTime(time1);
                        break;
                    case 3:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.offTime(time1);
                        break;
                    default:
                        //Menu1(objects);
                        break;

                }
            } else if (object instanceof Conditioner) {
                System.out.println("\nChange: \n1.Change condition\n2.Time On\n3.Time Off\n4.Temperature\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable) {
                    case 1:
                        if (object.isActive())
                            object.ElementOff();
                        else
                            object.ElementOn();
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 2:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.onTime(time1);
                        break;
                    case 3:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.offTime(time1);
                        break;
                    case 4:
                        System.out.print("Temperature: ");
                        ((Conditioner) object).setTemperature(s.nextInt());
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    default:
                        //Menu1(objects);
                        break;

                }
            } else if (object instanceof Shower_cabin){
                System.out.println("\nChange: \n1.Change condition\n2.Time On\n3.Time Off\n" +
                        "4.Temperature\n5.Change Hydro Massage\nelse.Get back");
                changeable = s.nextInt();
                switch (changeable) {
                    case 1:
                        if (object.isActive())
                            object.ElementOff();
                        else
                            object.ElementOn();
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 2:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.onTime(time1);
                        break;
                    case 3:
                        System.out.println("Time(int int): ");
                        time1.setHours(s.nextInt());
                        if (time1.getHours() > 23)
                            throw new InvalidAttributeValueException("Wrong hours value - " + time1.getHours());
                        time1.setMinutes(s.nextInt());
                        if (time1.getMinutes() > 59)
                            throw new InvalidAttributeValueException("Wrong minutes value - " + time1.getMinutes());
                        object.offTime(time1);
                        break;
                    case 4:
                        System.out.print("Temperature: ");
                        ((Shower_cabin) object).setTemperature(s.nextInt());
                        System.out.println("***CHANGE COMPLETE***");
                        break;
                    case 5:
                        if(((Shower_cabin) object).isHydroMassage())
                            ((Shower_cabin) object).OffHydroMassage();
                        else
                            ((Shower_cabin) object).OnHydroMassage();
                        break;
                    default:
                        //Menu1(objects);
                        break;
                }


        }
        } catch(InvalidAttributeValueException e){
        System.err.println("Wrong value of time: " + e.getMessage());
        throw new RuntimeException(e);
    }
    }

        private static void CreateNewObject(List<House> objects) throws IOException, InvalidKeyException {
        int changeable;
        Scanner s = new Scanner(System.in);
        System.out.println("\nWhat type:\n1.Fridge\n2.Blinds\n3.Lamp\n4.Conditioner\n5.Shower_cabin");

        changeable = s.nextInt();
        House house = null;
        boolean active;
        int Temperature;
        boolean Shower;
        Time time1 = new Time(0, 0);
        Time time2 = new Time(0, 0);

        System.out.print("Is active(true/false): ");
        active = s.nextBoolean();
        System.out.print("Time on(int int): ");
        time1.setHours(s.nextInt());
        time1.setMinutes(s.nextInt());
        System.out.print("Time off(int int): ");
        time2.setHours(s.nextInt());
        time2.setMinutes(s.nextInt());
        try {
            switch (changeable) {
                case 1:
                    System.out.print("Temperature(int): ");
                    Temperature = s.nextInt();
                    house = new Fridge(active, time1, time2, Temperature);
                    break;
                case 2:
                    house = new Blinds(active, time1, time2);
                    break;
                case 3:
                    house = new Lamp(active, time1, time2);
                    break;
                case 4:
                    System.out.print("Temperature(int): ");
                    Temperature = s.nextInt();
                    house = new Conditioner(active, time1, time2, Temperature);
                    break;
                case 5:
                    System.out.print("Temperature(int): ");
                    Temperature = s.nextInt();
                    System.out.print("Hydro Massage(true/false): ");
                    Shower = s.nextBoolean();
                    house = new Shower_cabin(active, time1, time2, Temperature, Shower);
                    break;
                default:
                    throw new InvalidKeyException("Invalid key:" + changeable);
            }
            objects.add(house);
        } catch (InvalidKeyException e) {
            System.err.println("Error:" + e.getMessage());
        }

    }

    private static void CreateStarterPack(List <House> objects)throws IOException{

        Time onTime2 = new Time(9, 0);
        Time offTime2 = new Time(18, 0);
        Blinds blinds1 = new Blinds(false, onTime2, offTime2);
        objects.add(blinds1);

        Time onTime3 = new Time(5, 0);
        Time offTime3 = new Time(8, 0);
        Lamp lamp1 = new Lamp(false, onTime3, offTime3);
        objects.add(lamp1);

        Time onTime1 = new Time(9, 0);
        Time offTime1 = new Time(22, 0);
        Fridge fridge1 = new Fridge(true, onTime1, offTime1, 15);
        objects.add(fridge1);

        Time onTime4 = new Time(15,30);
        Time offTime4 = new Time(19,30);
        Conditioner conditioner1 = new Conditioner(true, onTime4, offTime4, 18);
        objects.add(conditioner1);

        Time onTime5 = new Time(19,00);
        Time offTime5 = new Time(20,30);
        Shower_cabin shower_cabin1 = new Shower_cabin(true,onTime5, offTime5,65,true);
        objects.add(shower_cabin1);
        int i = 1;
        System.out.println("\n\t\tSTARTER PACK");
        for (House object : objects) {
            System.out.println(i++ + ": " + object);
        }
    }
}





















