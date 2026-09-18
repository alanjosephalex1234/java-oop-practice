// ==================== THE BASE HERO TEMPLATE ====================
abstract class hero
{
    private String name;
    private int health;
    private int dmg;
    private int mana1;

    public hero(String name, int health, int dmg, int mana1) {
        setName(name);
        setHealth(health);
        setDamage(dmg);
        setMana(mana1);
    }

    public void setName(String newName) { this.name = newName; }
    public String getName() { return this.name; }

    public void setHealth(int newHealth) {
        if (newHealth < 0) { this.health = 0; } else { this.health = newHealth; }
    }
    public int getHealth() { return this.health; }

    public void setDamage(int newDmg) {
        if (newDmg < 0) { this.dmg = 50; } else { this.dmg = newDmg; }
    }
    public int getDamage() { return this.dmg; }

    public void setMana(int newMana) {
        if (newMana < 0) { this.mana1 = 0; } else { this.mana1 = newMana; }
    }
    public int getMana() { return this.mana1; }

    // THE RULES FOR THE LOOP: Every child MUST have a shout and a useSpecial
    abstract void shout();
    abstract void useSpecial();
}

// ==================== SUBCLASSES (CHILDREN) ====================

class Warrior extends hero
{
    private int shieldStrength;

    public Warrior(String name, int health, int dmg, int mana1, int shieldStrength) {
        super(name, health, dmg, mana1);
        this.shieldStrength = shieldStrength;
    }

    @Override
    void shout() { System.out.println(getName() + " roars : FOR HONOUR AND GLORY!!"); }

    @Override
    void useSpecial() {
        System.out.println(getName() + "'s loyalty to Westhelm increases his shield strength by " + shieldStrength + "!");
    }
}

class Mage extends hero
{
    public Mage(String name, int health, int dmg, int mana1) {
        super(name, health, dmg, mana1);
    }

    @Override
    void shout() { System.out.println(getName() + " shouts : GLORY TO WESTHELM!!"); }

    @Override
    void useSpecial() {
        System.out.println(getName() + "'s loyalty to Westhelm increases his mana by " + getMana() + "!");
    }
}

class Rouge extends hero
{
    private int rougeStrength;

    public Rouge(String name, int health, int dmg, int mana1, int rougeStrength) {
        super(name, health, dmg, mana1);
        this.rougeStrength = rougeStrength;
    }

    @Override
    void shout() { System.out.println(getName() + " screams : TILL THE DEATH OF ALL ENEMIES!!"); }

    @Override
    void useSpecial() {
        System.out.println(getName() + "'s rage increases his strength by " + rougeStrength + "!!");
    }
}

class Archer extends hero
{
    private int accuracy;

    public Archer(String name, int health, int dmg, int mana1, int accuracy) {
        super(name, health, dmg, mana1);
        this.accuracy = accuracy;
    }

    @Override
    void shout() { System.out.println(getName() + " declares : KNEEL BEFORE MY BOW!"); }

    @Override
    void useSpecial() {
        System.out.println(getName() + "'s loyalty to Westhelm increases his accuracy by " + accuracy + "%!");
    }
}

// ==================== THE TRUNCATED GAME RUNNER ====================
class PlayHero
{
    public static void main(String args[])
    {
        // 1. Pack your squad array with different subclasses
        hero[] party = {
                new Mage("Strange", 50, 125, 100),
                new Warrior("Thorin", 150, 75, 50, 50),
                new Rouge("Brute", 200, 40, 40, 75),
                new Archer("Deadeye", 80, 100, 75, 75)
        };

        // 2. The Ultimate Loop: 4 lines of code executes the entire roster!
        for (hero h : party) {
            System.out.println(h.getName() + " has " + h.getHealth() + " HP, " + h.getDamage() + " damage and " + h.getMana() + " mana");
            h.shout();
            h.useSpecial(); // Java automatically finds the right move for each character!
            System.out.println("------------------------------------------------");
        }
    }
}