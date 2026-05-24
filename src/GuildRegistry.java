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
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setBountyRating(int bountyRating) {
        if(bountyRating<0) {this.bountyRating = 0;}
        else if(bountyRating>10) {this.bountyRating = 10;}
        else {this.bountyRating = bountyRating;}
    }

    public int getBountyRating() {return bountyRating;}
    abstract void trackTarget(String targetName);
}
class DroidHunter extends Hunter {
    public DroidHunter(String name, int bountyRating) {
        super(name, bountyRating);
    }
    @Override
    public void trackTarget(String targetName) {
        System.out.println(getName()+" is scanning the grid for "+targetName+"!");
    }
}
class CyborgHunter extends Hunter implements Augmentable {
    public CyborgHunter(String name, int bountyRating) {
        super(name, bountyRating);
    }
    @Override
    void trackTarget(String targetName) {
        System.out.println(getName()+" flies past planets in search of "+targetName);
    }
    @Override
    public void injectNanoBots() {
      System.out.println("Nanobots injected! "+getName()+"'s overall stats increasing astronomically!");
    }
}
class GuildRegistry {
    public static void main(String args[]) {
        Hunter[] List= {
                new DroidHunter("Reaper", 9),
                new CyborgHunter("Blitz Demon", 10)
        };
        System.out.println("--- RELEASING HUNTERS ---");
        for(Hunter i : List) {
            i.trackTarget("Han Solo");
            if(i instanceof Augmentable) {
                ((Augmentable) i).injectNanoBots();
            }
            System.out.println("=====================================================================");
        }
    }
}
