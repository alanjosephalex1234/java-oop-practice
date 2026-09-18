import java.util.ArrayList;

public class MiniFleet {
    public static void main(String[] args) {
        ArrayList<String> fleet = new ArrayList<>();
        fleet.add("X-Wing Alpha");
        fleet.add("Millennium Freighter");
        fleet.add("Ghost Stealth Raider");

        System.out.println("--- APPROACH 1: CLASSIC INDEX LOOP ---");
        for (int i = 0; i < fleet.size(); i++) {
            System.out.println("Dock " + i + " contains: " + fleet.get(i));
        }

        System.out.println("\n--- APPROACH 2: ENHANCED FOR-EACH ---");
        // Super clean syntax: No indices, no counters, no boundaries!
        for (var ship : fleet) {
            System.out.println("🚀 " + ship + " reporting for duty!");
        }
    }
}