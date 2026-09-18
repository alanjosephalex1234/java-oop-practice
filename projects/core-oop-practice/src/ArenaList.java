import java.util.ArrayList;
import java.util.Scanner;
interface CyberneticAugment {
    void activateOverdrive();
}
abstract class Gladiator {
    private String name;
    private int stamina;
    public Gladiator(String name, int stamina) {
        setName(name);
        setStamina(stamina);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setStamina(int stamina) {
        if(stamina<0) { this.stamina=0; }
        else { this.stamina=stamina; }
    }
    public int getStamina() {
        return stamina;
    }
    abstract void attack();
}
class Striker extends Gladiator implements CyberneticAugment {
    public Striker(String name, int stamina) {
        super(name, stamina);
    }
    @Override
    void attack() {
        System.out.println(getName()+" is winding up their sword to attack!");
    }
    @Override
    public void activateOverdrive() {
        System.out.println(getName()+" activating Overdrive! Power increasing rapidly!");
    }
}
class Defender extends Gladiator implements CyberneticAugment {
    public Defender(String name, int stamina) {
        super(name, stamina);
    }
    @Override
    void attack() {
        System.out.println(getName()+" is barging in with their shield!");
    }
    @Override
    public void activateOverdrive() {
        System.out.println(getName()+" activating Overdrive! Defense going up exponentially!");
    }
}
class Recruit extends Gladiator {
    public Recruit(String name, int stamina) {
        super(name, stamina);
    }

    @Override
    void attack() {
        System.out.println(getName() + " is charging at the enemies!");
    }
}
class ArenaList {
    public static void main(String args[]) {
        ArrayList<Gladiator> arenaRoster = new ArrayList<>();
        arenaRoster.add(new Striker("Void Blade", 100));
        arenaRoster.add(new Defender("Fortress", 200));
        arenaRoster.add(new Recruit("The Mask", 90));
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== ARENA ROSTER TERMINAL ===");
            System.out.println("1. View current roster");
            System.out.println("2. Add new Gladiator");
            System.out.println("3. Remove a Gladiator");
            System.out.println("4. Activate Overdrive");
            System.out.println("5. Shut down terminal");
            System.out.print("Select choice from 1-5: ");
            try {
                int choice = in.nextInt();
                in.nextLine();
                System.out.println("==========================================");
                switch (choice) {
                    case 1:
                        viewGladiators(arenaRoster);
                        break;
                    case 2:
                        addGladiator(in, arenaRoster);
                        break;
                    case 3:
                        removeGladiator(in, arenaRoster);
                        break;
                    case 4:
                        activateTech(in, arenaRoster);
                        break;
                    case 5:
                        System.out.println("Shutting down terminal...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Select a number from 1-5");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("======================================");
                System.out.println("CRITICAL ERROR!! Numerical protocol violated!");
                System.out.println("Reloading terminal safely!");
                System.out.println("=======================================");
                in.nextLine();
            }
        }
        in.close();
    }
    public static void viewGladiators(ArrayList<Gladiator> arenaRoster) {
        for(Gladiator h : arenaRoster) {
            System.out.println(h.getName()+"(Stamina: "+h.getStamina()+")");
        }
    }
    public static void addGladiator(Scanner in, ArrayList<Gladiator> arenaRoster) {
        System.out.print("Enter 1 for Striker, 2 for Defender or 3 for Recruit: ");
        int c=in.nextInt();
        in.nextLine();
        if(c==1) {
            System.out.print("Enter name for a new Striker: ");
            String newName=in.nextLine();
            System.out.print("Enter stamina level: ");
            int newStamina=in.nextInt();
            System.out.println("Success! "+newName+" has joined the roster");
            arenaRoster.add(new Striker(newName, newStamina));
        }
        else if(c==2) {
            System.out.print("Enter name for a new Defender: ");
            String newName=in.nextLine();
            System.out.print("Enter stamina level: ");
            int newStamina=in.nextInt();
            System.out.println("Success! "+newName+" has joined the roster");
            arenaRoster.add(new Defender(newName, newStamina));
        }
        else if(c==3) {
            System.out.print("Enter name for a new Recruit: ");
            String newName=in.nextLine();
            System.out.print("Enter stamina level: ");
            int newStamina=in.nextInt();
            System.out.println("Success! "+newName+" has joined the roster");
            arenaRoster.add(new Recruit(newName, newStamina));
        }
        else {
            System.out.println("Invalid Choice!");
        }
    }
    public static void removeGladiator(Scanner in, ArrayList<Gladiator> arenaRoster) {
        System.out.print("Enter name of Gladiator to be removed: ");
        String rname=in.nextLine();
        int isize=arenaRoster.size();
        for(int i=arenaRoster.size()-1;i>=0;i--) {
            if(arenaRoster.get(i).getName().equalsIgnoreCase(rname)) {
                System.out.println(rname+" has been removed from the roster!");
                arenaRoster.remove(i);
            }
        }
        if(isize==arenaRoster.size()) {
            System.out.println(rname+" is not on the roster");
        }
    }
    public static void activateTech(Scanner in, ArrayList<Gladiator> arenaRoster) {
        System.out.println("Activating Overdrive!");
        for(Gladiator h : arenaRoster) {
            if(h instanceof CyberneticAugment u) {
                u.activateOverdrive();
            }
            System.out.println("==============================================");
        }
    }
}