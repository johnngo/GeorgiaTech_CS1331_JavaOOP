public class Pond {
    public static void main(String[] args){
        //we create frog objects
        Frog Peepo = new  Frog("peepo");
        Frog Pepe = new Frog("Pepe", 10, 15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog Froyo = new Frog("Froyo", 5, 5);

        //we create fly objects
        Fly f1 = new Fly(1,3);
        Fly f2 = new Fly(6);
        Fly f3 = new Fly(2,2);

        //Set the species 
        Peepo.setSpecies("1331 Frogs");
        //print peepo's info
        System.out.println(Peepo.toString());

        Peepo.eat(f2);

        System.out.println(f2.toString());

        Peepo.grow(8);

        Peepo.eat(f2);
        System.out.println(f2.toString());
        System.out.println(Peepo.toString());
        System.out.println(Froyo.toString());
        //we grew peepaw
        Peepaw.grow(4);
        System.out.println(Peepaw.toString());
        System.out.println(Pepe.toString());
    }
}