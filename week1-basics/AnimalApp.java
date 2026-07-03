public class AnimalApp {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이");
        Cat cat = new Cat("나비");

        dog.eat();      // 부모한테 물려받은 동작
        dog.sound();    // 자기만의 동작

        cat.eat();
        cat.sound();
    }
}

// 부모 클래스 (공통 부분)
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + "가 먹는다");
    }

    void sound() {
        System.out.println(name + "가 소리를 낸다");
    }
}

// 자식 클래스 - Animal을 상속(extends)
class Dog extends Animal {
    Dog(String name) {
        super(name);    // 부모 생성자 호출
    }

    // 부모의 sound()를 자기 방식으로 덮어씀 (오버라이딩)
    @Override
    void sound() {
        System.out.println(name + ": 멍멍");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(name + ": 야옹");
    }
}