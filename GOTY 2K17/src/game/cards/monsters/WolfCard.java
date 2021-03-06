package game.cards.monsters;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.TileWorld;
import game.cards.Card;
import game.cards.curses.BlastCard;
import game.units.monsters.MonsterType;
import game.units.monsters.Zombie;

public class WolfCard extends MonsterSpawnCard {

	private static BufferedImage BASE_IMAGE;

	static {
		try {
			URL url = Zombie.class.getResource("/resources/cards/monsters/card_monster_wolf.png");
			BufferedImage spriteSheet = ImageIO.read(url);
			BASE_IMAGE = spriteSheet;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public WolfCard(TileWorld world) {
		super(BASE_IMAGE, world);
	}

	@Override
	public MonsterType getType() {
		return MonsterType.WOLF;
	}

	public String getName(){
		return "Wolf";
	}

	public Card copy (Card card){
		  Card f = new WolfCard(world);
		  return f;
	}
	
	public int getCost(){
		return 60;
	}
}
