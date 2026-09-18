abstract class CyberAbility{
    private String abilityName;
    private int energyCost;
    public CyberAbility(String abilityName, int energyCost){
        setAbilityName(abilityName);
        setEnergyCost(energyCost);
    }

    public void setAbilityName(String abilityName){this.abilityName=abilityName;}
    public String getAbilityName(){return this.abilityName;}

    public void setEnergyCost(int energyCost){
        if(energyCost<0){this.energyCost=0;}
        else{this.energyCost=energyCost;}
    }
    public int getEnergyCost(){return this.energyCost;}
    abstract void activate();
}
class CombatAugment extends CyberAbility{
    private int damageoutput;
    public CombatAugment(String name, int cost, int damage){
        super(name, cost);
        this.damageoutput=damage;
    }
    @Override
    void activate(){
        System.out.println("THE WORLD SHALL KNOW PAIN!!");
        System.out.println(getAbilityName()+" deals "+damageoutput+" damage!");
    }
}
class HackingProtocol extends CyberAbility{
    private String targetType;
    public HackingProtocol(String name, int cost, String targetType){
        super(name, cost);
        this.targetType=targetType;
    }
    @Override
    void activate(){
        System.out.println(targetType+" is being breached by "+getAbilityName()+". Shutting down internal components...");
    }
}
class NetrunnerTerminal{
    public static void main(String args[]){
        CyberAbility[] systemSlots= {
                new CombatAugment("Meltdown", 150, 1000),
                new HackingProtocol("UEMP-3", 100, "Control System")
        };
        System.out.println("----- ABILITY SPECIFICATIONS -----");
        for(CyberAbility i : systemSlots){
            System.out.println("Ability : "+i.getAbilityName()+" | Cost : "+i.getEnergyCost());
            i.activate();
            System.out.println("===========================================================");
        }
    }
}