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
        System.out.println(getShipName()+" charging Laser Canons!");
    }
    @Override
    public void engageWarp() {
        System.out.println(getShipName()+" punching it to Warp Factor 9!");
    }
}
class Dreadnought extends Starship implements WarpDrive {
    public Dreadnought(String shipName, int shieldLevel) {
        super(shipName, shieldLevel);
    }
    @Override
    void activateSystems() {
        System.out.println(getShipName()+" deploying heavy tracking arrays!");
    }
    @Override
    public void engageWarp() {
        System.out.println(getShipName()+" folding space-time fabric slowly...");
    }
}
class CargoShip extends Starship {
    public CargoShip(String shipName, int shieldLevel) {
        super(shipName, shieldLevel);
    }

    @Override
    public void activateSystems() {
        System.out.println(getShipName() + " warming up thrusters and securing cargo bays...");
    }
}
class GalaxyEmpire {
    public static void main(String args[]) {
        Starship[] fleet={
                new StarFighter("X-Wing Alpha", 100),
                new Dreadnought("Imperial Star Destroyer", 500),
                new CargoShip("Millennium Freighter", 200)
        };
        System.out.println("--- INITIALIZING FLEET COMMAND ---");
        for(Starship ship : fleet) {
            ship.activateSystems();
            if(ship instanceof WarpDrive) {
                ((WarpDrive) ship).engageWarp();
            }
            System.out.println("==========================================================================");
        }
    }
}
