public abstract class Pet {
    String name;
    // a percentage value ranging from 0.0 -1.0
    double health;
    // ranges from 1 to 10;
    int painLevel;
    //constructor
    public Pet(String name, double health, int painLevel){
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
    }
    //accessor
    public String getName() {
        return this.name;
    }
    //accessor - give other class access to this constructor
    public double getHealth(){
        return this.health;
    }
    //accessor
    public int getPainLevel(){
        return this.painLevel;
    }
    //abstract method
    public abstract int treat();

    //method
    public void speak() {
        String s = "Hello! My name is " + this.name;
        s = this.painLevel > 5 ? s.toUpperCase(): s;
        System.out.println(s);
    }
    //method
    public boolean equal(Object o) {
        return o instanceof Pet && name.equals(((Pet)o).name);
    }
    //method
    protected void heal() {
        this.health = 1.0;
        this.painLevel =1;
    }
}