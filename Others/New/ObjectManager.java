package Others.New;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ObjectManager {
    private BufferedImage spikeImg, PeaImg;
    private ArrayList<Projectile_hell> projectiles = new ArrayList<>();

    public ObjectManager(){
        loadImgs();
    }

    private void loadImgs(){
        PeaImg = LoadSave.GetSpriteAtlas(LoadSave.PEA);
        
    }
}
