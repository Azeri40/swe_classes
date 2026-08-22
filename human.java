public abstract class Character {
    private String name;
    private int life;
    private int energy;

    public Character(String name) {
        this.name = name;
        this.life = 100;
        this.energy = 150;
    }

    // ---------- Core actions ----------
    public void sleep() {
        this.energy = Math.min(150, this.energy + 10);
    }

    public void eat() {
        this.life = Math.min(100, this.life + 10);
    }

    public void takeDamage(int damage) {
        this.life = Math.max(0, this.life - damage);
    }

    public void attack(Character target) {
        target.takeDamage(10);
        setEnergy(this.energy - 5);
    }

    // ---------- Getters and Setters ----------
    public String getName() { return name; }

    public int getLife() { return life; }
    public void setLife(int life) {
        this.life = Math.max(0, Math.min(100, life));
    }

    public int getEnergy() { return energy; }
    public void setEnergy(int energy) {
        this.energy = Math.max(0, Math.min(150, energy));
    }

    @Override
    public String toString() {
        return name + " [life=" + life + ", energy=" + energy + "]";
    }

    public abstract void performSpecialAction();
}

// -----------------------------------------------------------------

class HumanWarrior extends Character {
    private int money = 1000;

    public HumanWarrior(String name) {
        super(name);
    }

    public void sell() {
        money += 100;
    }

    public void buy() {
        money = Math.max(0, money - 80);
    }

    public int getMoney() { return money; }

    @Override
    public void performSpecialAction() {
        System.out.println(getName() + " performs a powerful charge!");
        setEnergy(getEnergy() - 15);
    }

    @Override
    public String toString() {
        return super.toString() + ", money=" + money;
    }
}

// -----------------------------------------------------------------

class Wizard extends Character {
    public Wizard(String name) {
        super(name);
    }

    public String makePoison() {
        setEnergy(getEnergy() - 25);
        return "Felix the Poisonous";
    }

    @Override
    public void performSpecialAction() {
        System.out.println(getName() + " casts a healing spell!");
        setLife(getLife() + 20);
        setEnergy(getEnergy() - 10);
    }
}

// -----------------------------------------------------------------

class Shrek extends Character {
    private int happiness = 1000;

    public Shrek(String name) {
        super(name);
    }

    public void cryToDonkey() {
        setEnergy(getEnergy() - 30);
        happiness = Math.min(1000, happiness + 100);
    }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) {
        this.happiness = Math.max(0, Math.min(1000, happiness));
    }

    @Override
    public void performSpecialAction() {
        System.out.println(getName() + " lets out a mighty roar!");
        setEnergy(getEnergy() - 20);
        setHappiness(getHappiness() + 50);
    }

    @Override
    public String toString() {
        return super.toString() + ", happiness=" + happiness;
    }
}
