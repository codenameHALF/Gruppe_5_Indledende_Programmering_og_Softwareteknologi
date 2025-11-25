public class Staff{
    public static void main(String[] args) {
        Person adam = new Person();
        Boss bill = new Boss();
        Programmer carl = new Programmer();
        JavaProgrammer dean = new JavaProgrammer("Hej, Jeg koder i Java");
        JavaProgrammer eric = new JavaProgrammer("Hello World!");
        
        System.out.println(adam);
        System.out.println(bill);
        System.out.println(carl);
        System.out.println(dean);
        System.out.println(eric);
    }
}