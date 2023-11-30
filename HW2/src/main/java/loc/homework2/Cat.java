package loc.homework2;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public void makeSound(){
        System.out.println("Мяу!");
    }
}
