import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



public class    Main {

    public static void main(String[] args) throws IOException {
        //считываем данные из файла и добавляем в список
        List <Toy> toys  = readToysFromFile("toys.txt");

        System.out.println("\nINPUT FILE:\n");
        printToys(toys);

        //Фильтруем список по заданым критериям(необх. возраст 5, цена не больше 50) и сортируем по цене
        List <Toy> filtersToys = toys.stream()
                .filter(toy -> toy.getPrice() <= 50 && toy.getAgeRange().contains(5))
                .sorted(Comparator.comparing(Toy::getPrice))
                .collect(Collectors.toList());

        System.out.println("\nOUTPUT FILE:\n");
        printToys(filtersToys);

        //вывод полученого списка в новый файл
        WriteToysToFile(filtersToys,"filtered_toys.txt");
    }

    public static List<Toy> readToysFromFile(String filename) throws IOException{
        //считывание данных из файла и парсинг их в список объектов Toy
        List<Toy> toys = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String name = parts[0];
                int price = Integer.parseInt(parts[1]);
                int minAge = Integer.parseInt(parts[2]);
                int maxAge = Integer.parseInt(parts[3]);
                AgeRange ageRange = new AgeRange(minAge, maxAge);
                Toy toy;
                if(name.equals("doll")){
                    int size = Integer.parseInt(parts[4]);
                    toy = new Doll(name,price,ageRange,size);
                }
                else if(name.equals("ball")){
                    int weight = Integer.parseInt(parts[4]);
                    toy = new Ball(name,price,ageRange,weight);
                } else if (name.equals("blocks")) {
                    int numBlocks = Integer.parseInt(parts[4]);
                    toy = new Blocks(name, price, ageRange, numBlocks);
                } else if (name.equals("constructor")) {
                    int numConstructions = Integer.parseInt(parts[4]);
                    toy = new Constructor(name, price, ageRange, numConstructions);
                }
                else{
                    throw new IllegalArgumentException("Invalid name toy: " + name);
                }
                try{
                    toys.add(toy);
                }catch (IllegalArgumentException e)
                {
                    System.err.println("Error parcing toy data: "+ e.getMessage());
                }
            }
        }
        return  toys;
    }

    public static void printToys(List<Toy> toys) {
        for (Toy toy : toys) {
            System.out.print(toy.getName() + "," + toy.getPrice() + "," +
                    toy.getAgeRange().getMinAge() + "," + toy.getAgeRange().getMaxAge());
            if (toy instanceof Doll) {
                System.out.print("," + ((Doll) toy).getSize() + "\n");
            } else if (toy instanceof Ball) {
                System.out.print("," + + ((Ball) toy).getWeight() + "\n");
            } else if (toy instanceof Blocks) {
                System.out.print("," + ((Blocks) toy).getNumBlocks() + "\n");
            } else if (toy instanceof Constructor) {
                System.out.print("," + ((Constructor) toy).getNumConstructions() + "\n");
            }
            //System.out.println();
        }
    }

    private static void WriteToysToFile(List<Toy> toys, String filename) throws IOException{
        //Вывод полученого списка в файл
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Toy toy: toys)
            {
                writer.write(toy.getName() + "," + toy.getPrice() + "," +
                        toy.getAgeRange().getMinAge() + "," + toy.getAgeRange().getMaxAge());
                if(toy instanceof Doll)
                {
                    writer.write("," + ((Doll)toy).getSize());
                } else if (toy instanceof Ball) {
                    writer.write("," + ((Ball) toy).getWeight());
                } else if (toy instanceof Blocks) {
                    writer.write("," + ((Blocks) toy).getNumBlocks());
                } else if (toy instanceof Constructor) {
                    writer.write("," + ((Constructor) toy).getNumConstructions());
                }
                writer.newLine();
            }
        }
    }
}

class Toy
{
    private String name;

    private int price;

    private AgeRange ageRange;

    public Toy(String name, int price, AgeRange ageRange) {
        this.name = name;
        this.price = price;
        this.ageRange = ageRange;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public AgeRange getAgeRange(){
        return ageRange;
    }
}

class Doll extends Toy
{
    private int size;


    public Doll(String name, int price, AgeRange ageRange, int size) {
        super(name, price, ageRange);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Blocks extends Toy{
    private  int numBlocks;

    public Blocks(String name, int price, AgeRange ageRange, int numBlocks) {
        super(name, price, ageRange);
        this.numBlocks = numBlocks;
    }

    public int getNumBlocks() {
        return numBlocks;
    }
}

class Ball extends Toy{
    private int weight;

    public Ball(String name, int price, AgeRange ageRange, int weight) {
        super(name, price, ageRange);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Constructor extends Toy{
    private int numConstructions;

    public Constructor(String name, int price, AgeRange ageRange, int numConsructions) {
        super(name, price, ageRange);
        this.numConstructions = numConsructions;
    }

    public int getNumConstructions() {
        return numConstructions;
    }
}
class AgeRange{
    private int minAge;

    private int maxAge;

    public AgeRange(int minAge, int maxAge){
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public boolean contains(int Age)
    {
        return Age >= minAge && Age <= maxAge;
    }
}