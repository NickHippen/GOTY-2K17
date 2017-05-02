package game.units.traps;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.TileWorld;
import game.units.LivingUnit;

public class PitfallTrap extends Trap {

	private static BufferedImage IMAGE;
	
	static {
		try {
			URL url = PitfallTrap.class.getResource("/resources/units/traps/stun.png");
			IMAGE = ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public PitfallTrap(TileWorld world) {
		super(IMAGE, world);
	}

	@Override
	public void triggerEffect(LivingUnit livingUnit) {
		livingUnit.getStatusEffects().applyStunStatus();
	}

	@Override
	public String getName() {
		return "Pitfall Trap";
	}

}
