public class Fly {
    //instance variables
    private double mass;
    private double speed;

    public Fly(double initMass) {
        this(initMass, 10);
    }
    public Fly() {
        this(5, 10);
    }
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    public String toString() {
        String masses = String.format("%.2f", mass);
        String speedy = String.format("%.2f", speed);
        if (mass == 0) {
            return "I'm dead, but I used to be a fly with a speed of " + speedy + ".";
        } else {
            return "I'm a speedy fly with " + speedy + " speed and " + masses + " mass.";
        }
    }

    public void grow(int addMass) {
        //if mass is less than 20, increase speed by 1 for every mass the Fly grows until 20
        //if mass is greater than 20, decrease speed by 0.5 for every mass unit added over 20.
        if (mass < 20) {
            double diff = 20-mass;
            if (addMass > diff) {
                speed += diff;
                speed -= 0.5 * (addMass - diff);
            } else {
                speed += addMass;
            }
        } else {
            speed -= 0.5 * addMass;
        }
        mass += addMass;
    }

    public boolean isDead() {
        if (mass == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
};