class Dog extends Pet {
    //this class is concrete
    private double droolRate;
    //default droolRate
    private static final double DEFAULT_DROOL_RATE = 5.0;  
    //constructors
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_DROOL_RATE);
    }
    //constructors
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }
    //method
    public double getDroolRate() {
        return this.droolRate;
    }
    //method
    public int treat() {
        double health = this.getHealth();
        int painLevel = this.getPainLevel();
        this.heal();
        if(this.droolRate < 3.5)
            return(int)(painLevel*2/ health);
        return this.droolRate <=7.5? (int) (painLevel/health) : (int) (painLevel / (health *2));
    }
    //method
    public void speak() {
        super.speak();
        StringBuilder bark = new StringBuilder();
        bark.append("bark".repeat(Math.max(0, this.getPainLevel())));
        String b = this.getPainLevel() > 5 ? bark.toString().toUpperCase(): bark.toString();
        System.out.println(b);
    }
    //method
    public boolean equals(Object o) {
        if(o instanceof Dog)
            return super.equals(o) && this.droolRate == ((Dog) o).getDroolRate();
        return false;
    }

}