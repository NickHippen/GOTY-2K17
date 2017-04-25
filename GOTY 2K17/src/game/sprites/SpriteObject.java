package game.sprites;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.util.Matrix3x3f;
import game.vectors.Vector2f;

public class SpriteObject {

	protected int horizontalFrameNum = 1;
	protected int verticalFrameNum;
	protected int frameSize;
	
	private Matrix3x3f view;
	
	private Vector2f location;
	private float rotation;
	private double scale;
	
	private BufferedImage spriteSheet;
	private BufferedImage renderedImage;
	public SpriteObject(BufferedImage image) {
		this.spriteSheet = image;
		this.renderedImage = image;
		this.location = new Vector2f(0F, 0F);
		this.rotation = 0F;
		this.scale = 1;
		
		System.out.println(horizontalFrameNum);
		this.frameSize = this.spriteSheet.getWidth() / this.horizontalFrameNum;
	}
	
	public void draw(Graphics2D g) {
		AffineTransform transform = createTransform();
		g.drawImage(spriteSheet, transform, null);
	}
	
	private AffineTransform createTransform() {
		Vector2f screen = view.mul(location);
		AffineTransform transform = AffineTransform.getTranslateInstance(
				screen.x, screen.y);
		transform.rotate(rotation);
		if (scale != 1) {
			transform.translate(-renderedImage.getWidth() * (1 - scale) / 2, -renderedImage.getHeight() * (1 - scale) / 2);
		} else {
			transform.translate(-renderedImage.getWidth() / 2, -renderedImage.getHeight() / 2);
		}
		transform.scale(scale, scale);
		return transform;
	}
	
	public Matrix3x3f getView() {
		return view;
	}
	
	public void setView(Matrix3x3f view) {
		this.view = view;
	}
	
	public Vector2f getLocation() {
		return location;
	}
	
	public void setLocation(Vector2f location) {
		this.location = location;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	public double getScale() {
		return scale;
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	public void setHorizontalFrameNum(int horizontalFrameNum){
		this.horizontalFrameNum = horizontalFrameNum;
	}
	
	public int getHorizontalFrameNum(){
		return this.horizontalFrameNum;
	}
	
	public void setVerticalFrameNum(int verticalFrameNum){
		this.verticalFrameNum = verticalFrameNum;
	}
	
	public int getVerticalFrameNum(){
		return this.verticalFrameNum;
	}	
	
	public int getFrameSize(){
		return this.frameSize;
	}
	
	public BufferedImage getRenderedImage(){
		return this.renderedImage;
	}
	
	public BufferedImage getSpriteSheet(){
		return this.renderedImage;
	}
}
