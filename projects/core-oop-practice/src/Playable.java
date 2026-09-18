interface Playable{
    void play();
}
class Video implements Playable{
    @Override
    public void play(){
     System.out.println("Streaming high-definition video...");
    }
}
class Music implements Playable{
    @Override
    public void play(){
        System.out.println("Playing audio track through speakers...");
    }
}
class MediaController{
    public static void main(String args[]){
        Playable[] mediaQueue={
                new Video(),
                new Music()
        };
        System.out.println("-- SETTING UP MEDIA TO PLAY --");
        for(Playable media : mediaQueue){
            media.play();
            System.out.println("====================================================");
        }
    }
}
