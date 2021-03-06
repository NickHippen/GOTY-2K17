package game.cards.curses;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.TileWorld;
import game.cards.Card;
import game.units.Unit;
import game.units.monsters.Boss;
import game.units.monsters.Monster;
import game.units.monsters.Zombie;

public class HealCard extends UnitSelectCard {

	private static BufferedImage BASE_IMAGE;
	private static final int HEAL = 150;

	static {
		try {
			URL url = Zombie.class.getResource("/resources/cards/curses/heal.png");
			BufferedImage spriteSheet = ImageIO.read(url);
			BASE_IMAGE = spriteSheet;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public HealCard(TileWorld world) {
		super(BASE_IMAGE, world);
	}
	
	public String getName(){
		return "Heal";
	}

	@Override
	public void performAction(Unit unit) {
		if (unit instanceof Monster && !(unit instanceof Boss)) {
			Monster monster = (Monster) unit;
			monster.setHealth(monster.getHealth() + HEAL);
		}
	}

	public Card copy (Card card){
		  Card f = new HealCard(world);
		  return f;
	}
	
	public int getCost(){
		return 15;
	}
}
