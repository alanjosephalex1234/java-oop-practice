import java.util.ArrayList;
import java.util.Scanner;

interface WarpDrive {
    void engageWarp();
}
abstract class Starship {
    private String shipName;
    private int shieldLevel;
    public Starship(String shipName, int shieldLevel) {
        setShipName(shipName);
        setShieldLevel(shieldLevel);
    }
    public void setShipName(String shipName) {this.shipName = shipName;}
    public String getShipName() {
        return shipName;
    }
    public void setShieldLevel(int shieldLevel) {
        if(shieldLevel<0) {
            this.shieldLevel=0;
        }
        else {this.shieldLevel=shieldLevel;}
    }
    public int getShieldLevel() {
        return shieldLevel;
    }
    abstract void activateSystems();
}
class StarFighter extends Starship implements WarpDrive {
    public StarFighter(String shipName, int shieldLevel) {
        super(shipName, shieldLevel);
    }
    @Override
    void activateSystems() {
        System.out.println("["+getShipName()+"] charging Laser Canons!");
    }
    @Override
    public void engageWarp() {
        System.out.println("["+getShipName()+"] punching it to Warp Factor 9!");
    }
}
class Dreadnought extends Starship implements WarpDrive {
    public Dreadnought(String shipName, int shieldLevel) {
        super(shipName, shieldLevel);
    }
    @Override
    void activateSystems() {
        System.out.println("["+getShipName()+"] deploying heavy tracking arrays!");
    }
    @Override
    public void engageWarp() {
        System.out.println("["+getShipName()+"] folding space-time fabric slowly...");
    }
}
class CargoShip extends Starship {
    public CargoShip(String shipName, int shieldLevel) {
        super(shipName, shieldLevel);
    }

    @Override
    public void activateSystems() {
        System.out.println("["+getShipName()+"] warming up thrusters and securing cargo bays...");
    }
}
class GalaxyEmpire {
    public static void main(String args[]) {
        ArrayList<Starship> fleet = new ArrayList<>();
        fleet.add(new StarFighter("X-Wing Alpha", 100));
        fleet.add(new Dreadnought("Imperial Star Destroyer", 500));
        fleet.add(new CargoShip("Millennium Freighter", 200));

        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== FLEET MANAGEMENT TERMINAL ====");
            System.out.println("1. Scan deployed fleet status");
            System.out.println("2. Deploy new Starfighter");
            System.out.println("3. Deploy new Dreadnought");
            System.out.println("4. Deploy new Cargoship");
            System.out.println("5. Pull back deployed ship");
            System.out.println("6. Activate all ships");
            System.out.println("7. Shut down terminal");
            System.out.print("Select operational choice (1-7): ");

            try {
                int choice = in.nextInt();
                in.nextLine();
                System.out.println("=================================");

                switch(choice) {
                    case 1:
                        viewShips(fleet);
                        break;
                    case 2:
                        deployStarfighter(in, fleet);
                        break;
                    case 3:
                        deployDreadnought(in, fleet);
                        break;
                    case 4:
                        deployCargoship(in, fleet);
                        break;
                    case 5:
                        retreatShip(in,fleet);
                        break;
                    case 6:
                        activateShips(in, fleet);
                        break;
                    case 7:
                        System.out.println("Shutting down terminal...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Select a number between 1 and 6.");
                        break;
                }
            }
            catch(java.util.InputMismatchException e) {
                System.out.println("\n=================================");
                System.out.println("CRITICAL SYSTEM ERROR: Numerical input protocol violated.");
                System.out.println("Action aborted. Reloading menu interfaces safely...");
                System.out.println("=================================");
                in.nextLine();
            }
        }
        in.close();
    }
    public static void viewShips(ArrayList<Starship> fleet) {
        System.out.println("--- CURRENTLY DEPLOYED SHIPS ---");
        for(Starship h : fleet) {
            System.out.println("- ["+h.getShipName()+"]");
        }
    }

    public static void deployStarfighter(Scanner in, ArrayList<Starship> fleet) {
        System.out.print("Enter code name for new Star Fighter: ");
        String Name = in.nextLine();
        System.out.print("Enter shield level: ");
        int Shield = in.nextInt();
        fleet.add(new StarFighter(Name, Shield));
        System.out.println("Success! ["+Name+"] has joined the army");
    }

    public static void deployDreadnought(Scanner in, ArrayList<Starship> fleet) {
        System.out.print("Enter code name for new Dreadnought: ");
        String Name = in.nextLine();
        System.out.print("Enter shield level: ");
        int Shield = in.nextInt();
        fleet.add(new Dreadnought(Name, Shield));
        System.out.println("Success! [" + Name + "] is ready to serve some pain");
    }

    public static void deployCargoship(Scanner in, ArrayList<Starship> fleet) {
        System.out.print("Enter code name for new Cargo Ship: ");
        String Name = in.nextLine();
        System.out.print("Enter shield level: ");
        int Shield = in.nextInt();
        fleet.add(new CargoShip(Name, Shield));
        System.out.println("Success! [" + Name + "] is ready to hold the defense");
    }

    public static void retreatShip(Scanner in, ArrayList<Starship> fleet) {
        System.out.print("Enter ship name to be retreated: ");
        String name = in.nextLine();
        int isize = fleet.size();
        for(int i=fleet.size()-1;i>=0;i--) {
            if(fleet.get(i).getShipName().equalsIgnoreCase(name)) {
                System.out.println("Retreating ["+fleet.get(i).getShipName()+"] from battlefield");
                fleet.remove(i);
            }
        }
        if(fleet.size()==isize) {
            System.out.println("["+name+"] is not present on the battlefield");
        }
    }
    public static void activateShips(Scanner in, ArrayList<Starship> fleet) {
        System.out.println("==== ACTIVATING ALL SHIPS ====");
        for(Starship i : fleet) {
            System.out.println("Activating ["+i.getShipName()+"]");
            i.activateSystems();
            if(i instanceof WarpDrive u) {
                u.engageWarp();
            }
            System.out.println("==================================================");
        }
    }
}

