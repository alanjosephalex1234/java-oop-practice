// ==================== THE BASE VEHICLE TEMPLATE ====================
abstract class Vehicle
{
    private String modelName;
    private int topSpeed;
    private int batteryLevel;

    // Core Constructor: Sets up the base stats for ANY vehicle
    public Vehicle(String modelName, int topSpeed, int batteryLevel) {
        setModelName(modelName);
        setTopSpeed(topSpeed);
        setBatteryLevel(batteryLevel);
    }

    public void setModelName(String modelName) { this.modelName = modelName; }
    public String getModelName() { return this.modelName; }

    public void setTopSpeed(int topSpeed) { this.topSpeed = topSpeed; }
    public int getTopSpeed() { return this.topSpeed; }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) { this.batteryLevel = 0; }
        else if (batteryLevel > 100) { this.batteryLevel = 100; }
        else { this.batteryLevel = batteryLevel; }
    }
    public int getBatteryLevel() { return this.batteryLevel; }

    // Every vehicle must know how to boot its systems and execute its main tech function
    abstract void bootSystems();
    abstract void activateTech();
}

// ==================== SUBCLASSES (THE SPECIES) ====================

class CyberCar extends Vehicle
{
    private boolean autopilotEnabled;

    // Constructor: passes base stats up, then configures its own unique autopilot feature
    public CyberCar(String modelName, int topSpeed, int batteryLevel, boolean autopilotEnabled) {
        super(modelName, topSpeed, batteryLevel);
        this.autopilotEnabled = autopilotEnabled;
    }

    @Override
    void bootSystems() {
        System.out.println("[" + getModelName() + "]: Quantum AI Online. Scanning perimeter.");
    }

    @Override
    void activateTech() {
        System.out.println("[" + getModelName() + "]: Autopilot status: " + autopilotEnabled + ". Engaging highway grid link.");
    }
}

class HoverBike extends Vehicle
{
    private int altitudeLimit;

    public HoverBike(String modelName, int topSpeed, int batteryLevel, int altitudeLimit) {
        super(modelName, topSpeed, batteryLevel);
        this.altitudeLimit = altitudeLimit;
    }

    @Override
    void bootSystems() {
        System.out.println("[" + getModelName() + "]: Anti-gravity thrusters warming up. Repulsors calibrated.");
    }

    @Override
    void activateTech() {
        System.out.println("[" + getModelName() + "]: Ascending to maximum altitude of " + altitudeLimit + " meters!");
    }
}

class CargoDrone extends Vehicle
{
    private int maxLoadCapacity;

    public CargoDrone(String modelName, int topSpeed, int batteryLevel, int maxLoadCapacity) {
        super(modelName, topSpeed, batteryLevel);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    @Override
    void bootSystems() {
        System.out.println("[" + getModelName() + "]: Rotor blades unlocked. GPS satellite lock established.");
    }

    @Override
    void activateTech() {
        System.out.println("[" + getModelName() + "]: Heavy magnets active. Maximum lifting capability: " + maxLoadCapacity + "kg.");
    }
}
class Submarine extends Vehicle
{
    private int maxDepth;
    public Submarine(String modelName, int topSpeed, int batteryLevel, int maxDepth){
        super(modelName, topSpeed, batteryLevel);
        this.maxDepth = maxDepth;
    }
    @Override
    void bootSystems(){
        System.out.println("[" + getModelName() + "]: All systems online. Ready to submerge.");
    }
    @Override
    void activateTech(){
        System.out.println("[" + getModelName() + "]: Thrusters active. Descending to maximum depth: " + maxDepth + "m.");
    }
}

// ==================== THE MAIN GARAGE EXECUTION ====================
class NeoGarage
{
    public static void main(String[] args)
    {
        // Polymorphic Collection: An array of type 'Vehicle' holding entirely different classes!
        Vehicle[] neonGarage = {
                new CyberCar("Quadra V-Tech", 220, 95, true),
                new HoverBike("Yaiba Kusanagi", 310, 80, 15),
                new CargoDrone("Zetatech Atlas", 90, 100, 500),
                new Submarine("Trench Explorer", 100, 100, 11000)
        };

        System.out.println("--- INITIATING GARAGE BOOT SEQUENCE ---\n");

        // Single loop manages the entire automated garage, regardless of the vehicle type
        for (Vehicle v : neonGarage) {
            System.out.println("Vehicle: " + v.getModelName() + " | Top Speed: " + v.getTopSpeed() + " km/h | Battery: " + v.getBatteryLevel() + "%");
            v.bootSystems();
            v.activateTech();
            System.out.println("----------------------------------------------------------------");
        }
    }
}
