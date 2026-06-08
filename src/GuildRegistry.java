import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

interface Augmentable {
    void injectNanoBots();
}

abstract class Hunter {
    private String name;
    private int bountyRating;

    public Hunter(String name, int bountyRating) {
        setName(name);
        setBountyRating(bountyRating);
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setBountyRating(int bountyRating) {
        if (bountyRating < 0) { this.bountyRating = 0; }
        else if (bountyRating > 10) { this.bountyRating = 10; }
        else { this.bountyRating = bountyRating; }
    }

    public int getBountyRating() { return bountyRating; }
    abstract void trackTarget(String targetName);
}

class DroidHunter extends Hunter {
    public DroidHunter(String name, int bountyRating) { super(name, bountyRating); }
    @Override
    public void trackTarget(String targetName) {
        System.out.println(getName() + " is scanning the grid for " + targetName + "!");
    }
}

class CyborgHunter extends Hunter implements Augmentable {
    public CyborgHunter(String name, int bountyRating) { super(name, bountyRating); }
    @Override
    void trackTarget(String targetName) {
        System.out.println(getName() + " flies past planets in search of " + targetName);
    }
    @Override
    public void injectNanoBots() {
        System.out.println("Nanobots injected! " + getName() + "'s overall stats increasing astronomically!");
    }
}

class GuildRegistry {
    public static void main(String args[]) {
        ArrayList<Hunter> list = new ArrayList<>();
        list.add(new DroidHunter("Reaper", 9));
        list.add(new CyborgHunter("Blitz Demon", 10));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== GUILD MANAGEMENT TERMINAL ===");
            System.out.println("1. View Active Hunters");
            System.out.println("2. Recruit a New Droid Hunter");
            System.out.println("3. Recruit a New Cyborg Hunter");
            System.out.println("4. Decommission Underperforming Assets");
            System.out.println("5. Shut Down Terminal");
            System.out.print("Select operational choice (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println("=================================");

                switch (choice) {
                    case 1:
                        viewHunters(list);
                        break;
                    case 2:
                        recruitDroid(scanner, list);
                        break;
                    case 3:
                        recruitCyborg(scanner, list);
                        break;
                    case 4:
                        purgeLowRatings(list);
                        break;
                    case 5:
                        System.out.println("Terminating secure link... Goodbye.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Select a matrix index between 1 and 5.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n=================================");
                System.out.println("CRITICAL SYSTEM ERROR: Numerical input protocol violated.");
                System.out.println("Action aborted. Reloading menu interfaces safely...");
                System.out.println("=================================");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void viewHunters(ArrayList<Hunter> list) {
        System.out.println("--- CURRENT REGISTERED HUNTERS ---");
        for (Hunter h : list) {
            System.out.println("- " + h.getName() + " (Bounty Rating: " + h.getBountyRating() + ")");
        }
    }

    public static void recruitDroid(Scanner scanner, ArrayList<Hunter> list) {
        System.out.print("Enter code name for the new Droid Hunter: ");
        String name = scanner.nextLine();

        int rating = -1;
        boolean validRating = false;

        while (!validRating) {
            System.out.print("Assign initial Bounty Rating (1-10): ");
            rating = scanner.nextInt();

            if (rating >= 1 && rating <= 10) {
                validRating = true;
            } else {
                System.out.println("MATRIX ERROR: Rating out of bounds. The Guild only accepts ratings 1 through 10.");
            }
        }

        list.add(new DroidHunter(name, rating));
        System.out.println("Success! [" + name + "] has joined the operational grid.");
    }

    public static void recruitCyborg(Scanner scanner, ArrayList<Hunter> list) {
        System.out.print("Enter code name for the new Cyborg Hunter: ");
        String name = scanner.nextLine();

        int rating = -1;
        boolean validRating = false;

        while(!validRating) {
        System.out.print("Assign initial Bounty Rating (1-10): ");
        rating = scanner.nextInt();

            if (rating >= 1 && rating <= 10) {
                validRating = true;
            } else {
                System.out.println("MATRIX ERROR: Rating out of bounds. The Guild only accepts ratings 1 through 10.");
            }
        }

        list.add(new CyborgHunter(name, rating));
        System.out.println("Success! [" + name + "] has been augmented and registered.");
    }

    public static void purgeLowRatings(ArrayList<Hunter> list) {
        int initialSize = list.size();

        System.out.println("Initiating registry purge protocols...");
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getBountyRating() < 9) {
                System.out.println("Decommissioning asset: [" + list.get(i).getName() + "]");
                list.remove(i);
            }
        }

        if (list.size() == initialSize) {
            System.out.println("Audit complete. All hunters performing up to standards!");
        } else {
            System.out.println("Purge complete. Underperforming elements zeroed out.");
        }
    }
}