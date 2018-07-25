package jvm;


/**
 * @author zhangjingsi
 * @date 2018/5/3上午11:50
 */
public class ExecuteMock {
    private static Animal animal1 = new Animal(5, "dog");
    private Animal animal2 = new Animal(7, "duck");
    public static void main(String[] args) {
        ExecuteMock executeMock = new ExecuteMock();
        Animal animal3 = new Animal(3, "cat");

        ExecuteMock executeMock1 = new ExecuteMock();
        String s = new String("s");
        ExecuteMock.animal1.printName(executeMock1, s);
        executeMock.animal2.printName( executeMock1, s);
        animal3.printName(executeMock1, s);
        System.out.println("end");
    }
}
class Animal{
    private Integer age;
    private String name;
    private Animal subAnimal;
    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Animal getSubAnimal() {
        return subAnimal;
    }

    public void setSubAnimal(Animal subAnimal) {
        this.subAnimal = subAnimal;
    }

    public void printName(ExecuteMock e1, String s){
        System.out.println(s);
        s = s+"s";
        Animal.test( e1, s);

        int old = 5;
        String s3;
        if (this.age > old){
            s3 = this.name + this.age;
        }else{
            s3 = this.name;
        }
        System.out.println(s3);
    }

    public static void test(ExecuteMock e1, String s){
        System.out.println(e1.toString() + s);
    }
}
