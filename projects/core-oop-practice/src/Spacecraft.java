abstract class Spacecraft{
    private String name;
    private int fuelLevel;

    public Spacecraft(String name, int fuelLevel){
        setName(name);
        setFuelLevel(fuelLevel);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setFuelLevel(int fuelLevel){
        if (fuelLevel<0){ this.fuelLevel = 0;}
        else if (fuelLevel>100){this.fuelLevel=100;}
        else {this.fuelLevel=fuelLevel;}
    }
    public int getFuelLevel(){return this.fuelLevel;}

    abstract void launch();
}

class Rocket extends Spacecraft{
    private int thrusterCount;
    public Rocket(String name, int fuelLevel, int thrusterCount){
        super(name, fuelLevel);
        this.thrusterCount=thrusterCount;
    }

    @Override
    void launch(){
        System.out.println("Starship ["+getName()+"] igniting all "+thrusterCount+" thrusters! Current fuel: "+getFuelLevel()+"%.");
    }
}

class Rover extends Spacecraft{
    private String targetPlanet;
    public Rover(String name, int fuelLevel, String targetPlanet){
     super(name, fuelLevel);
     this.targetPlanet=targetPlanet;
    }

    @Override
    void launch(){
        System.out.println("["+getName()+"] deployed! Beginning surface exploration on planet ["+targetPlanet+"] with "+getFuelLevel()+"% battery remaining.");
    }
}

class MissionControl{
    public static void main(String args[]){
        Spacecraft[] Fleet={
                new Rocket("Stardasher", 95, 8),
                new Rover("APX-3", 100, "Mars")
        };
        System.out.println("---- INITIATING SPACECRAFT ----");
        for(Spacecraft i : Fleet){
            System.out.println("Vehicle : "+i.getName());
            i.launch();
            System.out.println("========================================================================================");
        }
    }
}
