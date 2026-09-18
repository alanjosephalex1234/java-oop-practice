import java.util.ArrayList;
import java.util.Scanner;
interface StealthModule {
    void activateCloaking();
}
abstract class Drone {
    private String modelName;
    private int batteryLevel;
    public Drone(String modelName, int batteryLevel) {
        setModelName(modelName);
        setBatteryLevel(batteryLevel);
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) {this.batteryLevel = 0;}
        else if (batteryLevel > 100) {this.batteryLevel = 100;}
        else {this.batteryLevel=batteryLevel;}
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    abstract void performMission();
}
class ReconDrone extends Drone implements StealthModule {
    public ReconDrone(String modelName, int batteryLevel) {
        super(modelName, batteryLevel);
    }
    @Override
    void performMission() {
        System.out.println("["+getModelName()+"] is scanning enemy coordinates silently.");
    }
    @Override
    public void activateCloaking() {
        System.out.println("["+getModelName()+"] shifting light spectrum. Cloaking at 100%!");
    }
}
class CombatDrone extends Drone implements StealthModule {
    public CombatDrone(String modelName, int batteryLevel) {
        super(modelName, batteryLevel);
    }
    @Override
    void performMission() {
        System.out.println("["+getModelName()+"] is engaging target locks!");
    }
    @Override
    public void activateCloaking() {
        System.out.println("["+getModelName()+"] dampening thermal signatures. Ghost mode active!");
    }
}
class CargoDrone1 extends Drone {
    public CargoDrone1(String modelName, int batteryLevel) {
        super(modelName, batteryLevel);
    }
    @Override
    void performMission() {
        System.out.println("["+getModelName()+"] is hauling heavy supply crates to headquarters.");
    }
}
class DroneControl {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        ArrayList<Drone> garage= new ArrayList<>();
        garage.add(new ReconDrone("Ghost", 95));
        garage.add(new CombatDrone("Striker", 90));
        garage.add(new CargoDrone1("Titan Lifter", 90));
        boolean running=true;
        while(running) {
            System.out.println("=== DRONE MANAGEMENT TERMINAL ===");
            System.out.println("1. View current fleet");
            System.out.println("2. Deploy new Drone");
            System.out.println("3. Decommission existing Drone");
            System.out.println("4. Trigger stealth protocol");
            System.out.println("5. Shut down terminal");
            System.out.print("Enter operational choice from 1-5: ");
            try {
                int choice=in.nextInt();
                in.nextLine();
                System.out.println("===========================================");
                switch(choice) {
                    case 1:
                        viewCurrentFleet(garage);
                        break;
                    case 2:
                        deployNewDrone(in, garage);
                        break;
                    case 3:
                        decommissionDrone(in, garage);
                        break;
                    case 4:
                        triggerStealth(garage);
                        break;
                    case 5:
                        System.out.println("Shutting down terminal...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Enter any number from 1-5");
                        break;
                }
            }
            catch(java.util.InputMismatchException e) {
                System.out.println("======================================================");
                System.out.println("CRITICAL ERROR!! Numeric input protocol violated!");
                System.out.println("Reloading terminal safely");
                System.out.println("======================================================");
                in.nextLine();
            }
        }
        in.close();
    }
    public static void viewCurrentFleet(ArrayList<Drone> garage) {
        System.out.println("Currently deployed fleet:");
        for(Drone i : garage) {
            System.out.println("["+i.getModelName()+"]. Battery level: "+i.getBatteryLevel());
        }
    }
    public static void deployNewDrone(Scanner in, ArrayList<Drone> garage) {
        System.out.print("Enter 1 for Recon Drone, 2 for Combat Drone or 3 for Cargo Drone: ");
        int c=in.nextInt();
        in.nextLine();
        if(c==1) {
            System.out.print("Enter Recon Drone name: ");
            String newName=in.nextLine();
            int newbatteryLevel=-1;
            boolean validRating=false;
            while(!validRating) {
                System.out.print("Enter battery level (0-100): ");
                newbatteryLevel = in.nextInt();
                if(newbatteryLevel>=0 && newbatteryLevel<=100) {
                    validRating=true;
                }
                else {
                    System.out.println("Input rejected! Enter a value between 0 and 100.");
                }
            }
            garage.add(new ReconDrone(newName, newbatteryLevel));
            System.out.println("["+newName+"] has been added to the fleet!");
        }
        else if(c==2) {
            System.out.print("Enter Combat Drone name: ");
            String newName = in.nextLine();
            int newbatteryLevel=-1;
            boolean validRating=false;
            while(!validRating) {
                System.out.print("Enter battery level (0-100): ");
                newbatteryLevel = in.nextInt();
                if(newbatteryLevel>=0 && newbatteryLevel<=100) {
                    validRating=true;
                }
                else {
                    System.out.println("Input rejected! Enter a value between 0 and 100.");
                }
            }
            garage.add(new CombatDrone(newName, newbatteryLevel));
            System.out.println("["+newName+"] has been added to the fleet!");
        }
        else if(c==3) {
            System.out.print("Enter Cargo Drone name: ");
            String newName=in.nextLine();
            int newbatteryLevel=-1;
            boolean validRating=false;
            while(!validRating) {
                System.out.print("Enter battery level (0-100): ");
                newbatteryLevel = in.nextInt();
                if(newbatteryLevel>=0 && newbatteryLevel<=100) {
                    validRating=true;
                }
                else {
                    System.out.println("Input rejected! Enter a value between 0 and 100.");
                }
            }
            garage.add(new CargoDrone1(newName, newbatteryLevel));
            System.out.println("["+newName+"] has been added to the fleet!");
        }
        else {
            System.out.println("Invalid input! Enter a number between 1 and 3.");
        }
    }
    public static void decommissionDrone(Scanner in, ArrayList<Drone> garage) {
        System.out.print("Enter name of drone to be decommissioned: ");
        String rname=in.nextLine();
        int isize=garage.size();
        for(int i=garage.size()-1;i>=0;i--) {
            if(garage.get(i).getModelName().equalsIgnoreCase(rname)) {
                System.out.println("["+garage.get(i).getModelName()+"] has been decommissioned!");
                garage.remove(i);
            }
        }
        if(isize==garage.size()) {
            System.out.println("["+rname+"] is currently not active!");
        }
    }
    public static void triggerStealth(ArrayList<Drone> garage) {
        for(Drone i : garage) {
            if(i instanceof StealthModule u) {
                u.activateCloaking();
            }
        }
        System.out.println("============================================");
    }
}