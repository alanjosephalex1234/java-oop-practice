interface SmartDevice {
    void turnon();
}
class Light implements SmartDevice{
    @Override
    public void turnon(){
        System.out.println("Light turned on. Brightness set to 100%.");
    }
}
class Thermostat implements SmartDevice{
    @Override
    public void turnon(){
        System.out.println("Thermostat activated. Adjusting temperature to 22'C.");
    }
}
class SmartHomeApp{
    public static void main(String args[]){
        SmartDevice[] homeDevices={
                new Light(),
                new Thermostat()
        };
        for(SmartDevice device : homeDevices){
            device.turnon();
            System.out.println("=================================================================");
        }
    }
}