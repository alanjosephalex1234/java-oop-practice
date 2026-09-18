interface Upgradable {
    void upgrade();
}
    abstract class Artifact{
    private String artifactName;
    private int powerLevel;
    public Artifact(String artifactName, int powerLevel){
        setArtifactName(artifactName);
        setPowerLevel(powerLevel);
    }
    public void setArtifactName(String artifactName){this.artifactName=artifactName;}
    public String getArtifactName(){return this.artifactName;}
    public void setPowerLevel(int powerLevel){
        if(powerLevel <0){this.powerLevel=0;}
        else if(powerLevel >100){this.powerLevel=100;}
        else{this.powerLevel=powerLevel;}
    }
    public int getPowerLevel(){return this.powerLevel;}
    abstract void activateRelic();
}
class EnchantedWeapon extends Artifact implements Upgradable{
    private int physicalDamage;
    public EnchantedWeapon(String artifactName, int powerLevel, int physicalDamage){
        super(artifactName, powerLevel);
        this.physicalDamage=physicalDamage;
    }
    @Override
    void activateRelic(){
        System.out.println("["+getArtifactName()+"] unleashed! Striking for "+physicalDamage+" damage with a magic power of "+getPowerLevel()+"%");
    }
    @Override
    public void upgrade(){
        this.physicalDamage=physicalDamage+50;
        System.out.println("["+getArtifactName()+"] has been forged anew! Damage increased by 50!");
    }
}
class HealingScroll extends Artifact implements Upgradable{
    private String targetSpell;
    public HealingScroll(String artifactName, int powerLevel, String targetSpell){
        super(artifactName, powerLevel);
        this.targetSpell=targetSpell;
    }
    @Override
    void activateRelic(){
        System.out.println("["+getArtifactName()+"] activated! Casting ["+targetSpell+"] to heal the party. Potency: "+getPowerLevel()+"%");
    }
    @Override
    public void upgrade(){
     this.targetSpell=targetSpell+" V2";
     System.out.println("Mystic runes etched onto ["+getArtifactName()+"]! Spell upgraded to ["+targetSpell+"]!");
    }
}
class RelicVault{
    public static void main(String args[]){
        EnchantedWeapon weapon  = new EnchantedWeapon("Shatterstar", 98, 500);
        HealingScroll scroll = new HealingScroll("Totem of Life", 95, "Life Force");
        System.out.println("---- UPGRADING GEAR ----");
        weapon.upgrade();
        scroll.upgrade();
        System.out.println("=======================================\n");
        Artifact[] vaultInventory={weapon, scroll};
        System.out.println("---- ACTIVATING RELICS ----");
        for(Artifact i : vaultInventory){
            System.out.println("Relic ["+i.getArtifactName()+"] activating! Power levels increasing to maximum of "+i.getPowerLevel()+"%");
            i.activateRelic();
            System.out.println("=================================================================");
        }
    }
}
