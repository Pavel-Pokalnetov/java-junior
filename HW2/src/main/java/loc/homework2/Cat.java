package loc.homework2;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public void makeMeau(){
        System.out.println("Мяу!");
    }
}
