package game.cards.curses;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.TileWorld;
import game.units.LivingUnit;
import game.units.Unit;
import game.units.monsters.Zombie;

public class BlastCard extends AreaCard {

	private static BufferedImage BASE_IMAGE;

	static {
		try {
			URL url = Zombie.class.getResource("/resources/cards/curses/blast.png");
			BufferedImage spriteSheet = ImageIO.read(url);
			BASE_IMAGE = spriteSheet;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public BlastCard(TileWorld world) {
		super(BASE_IMAGE, world);
	}
	
	public String getName(){
		return "Blast";
	}

	public void affectUnit(Unit unit) {
		if(unit instanceof LivingUnit) ((LivingUnit) unit).setHealth(((LivingUnit) unit).getHealth() - 50);
	}

}
