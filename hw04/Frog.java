public class Frog{
    // specific visibility modifier
       private String name; 
       private int age;  //in months
       private double tongueSpeed;
       private boolean isFroglet;
       private static String species ="Rare Pepe";
       public static double MIN_TONGUESPEED =5;
    
        //constructors
       public Frog(String name){
            this(name, 5,5);
       }
    
       public Frog(String name, double ageInYear, double tongueSpeed){
           this(name, (int)(ageInYear*12), tongueSpeed);
       }
    
       public Frog(String name, int age, double tongueSpeed){
           this.name = name;
           this.age = age;
           this.tongueSpeed = tongueSpeed;
           this.updateIsFroglet();
    
           if(this.age > 1 && this.age <=7){
               isFroglet = true;
           }else {
               isFroglet= false;
           }
       }   
       //methods
     public void grow(int addAge){
    
        if(age < 12){
            int diff = 12-age;
            if(addAge > diff){
                tongueSpeed +=diff;
            }else {
                tongueSpeed += addAge;
            }
        }else{
            if(age >30){
                if(tongueSpeed <=5){
                    tongueSpeed=tongueSpeed;
                }else{
                    double differ = tongueSpeed-5;
                    if(differ <5 && addAge > 0){
                        tongueSpeed -= differ;
                    }else{
                        tongueSpeed -=addAge;
                    }              
                }
            }else{
                if(age+addAge<30){
                    tongueSpeed=tongueSpeed;
                }else {
                    tongueSpeed -= 1*(addAge+age-30);
                }
            }
        }age += addAge;
    
        public void grow(){
            this.grow(1);
        }
    
    
       public void eat(Fly fly) {
        if (!fly.isDead()) {
            if (this.tongueSpeed > fly.getSpeed()) {
                if (fly.getMass() >= this.age * 0.5)
                    this.grow(1);
                fly.setMass(0);
            } else {
                fly.setMass(fly.getMass() + 1);
            }
        }
    }
       public String toString(){
           String tongue = String.format("%.2f", tongueSpeed);
           if(isFroglet ==true){
               return "My name is " + name + " and I'm a rare froglet! I'm " +age+ " months old and my tongue has a speed of " + tongue +".";
           }
           return "My name is " + name + " and I'm a rare frog. I'm " + age+ " months old and my tongue has a speed of " + tongue +".";
       }
       
       private void updateIsFroglet(){
            if (1 < this.age && this.age < 7)
                this.isFroglet = true;
            else
                this.isFroglet = false;
       }
    
       //setters(mutators) & getters(accessors)
       public static void setSpecies(String newSpecies){
            Frog.species = newSpecies;
       }
    
       public static String getSpecies(){
            return Frog.species;
       }
    }