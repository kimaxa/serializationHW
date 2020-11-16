package src;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class HW {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pizza pizza = new Pizza();
        pizza.filling = "Hawaii";
        pizza.dough.size = "30";
        pizza.dough.type = "classic";


        //Произвести сериализацию объекта, используя ObjectOutputStream
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Pizza Serializable"));
        outputStream.writeObject(pizza);
        outputStream.close();

        //Произвести десериализацию файла, используя ObjectInputStream, вывести объект в консоль
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Pizza Serializable"));
        Pizza pizzaResulted = (Pizza) inputStream.readObject();
        inputStream.close();
        System.out.println(pizzaResulted);

        //Произвести сериализацию объекта, используя Gson
        Gson gson = new Gson();
        File file = new File("pizza.json");
        String jsonString  = gson.toJson(pizza);
        Files.write(Paths.get("pizza.json"), jsonString.getBytes());

        //Произвести десериализацию json файла, используя Gson, вывести объект в консоль
        jsonString = new String(Files.readAllBytes(Paths.get("pizza.json")), StandardCharsets.UTF_8);
        Pizza pizzaResulted1 = gson.fromJson(jsonString, Pizza.class);
        System.out.println(pizzaResulted1);
    }

}
