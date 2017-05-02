package game.sound;

import java.io.*;
import java.net.URL;

import game.util.*;

public class PlayerControl {
	private BlockingClip clip;
	private LoopEvent loopClip;
	private LoopEvent loopStream;
	private byte[] rawSound;

	public PlayerControl(){
		FileInputStream in1;
	InputStream in = PlayerControl.class.getResourceAsStream("/resources/sound/Background.wav");
		
		rawSound = readBytes(in);
		clip = new BlockingClip(rawSound);
		loopClip = new LoopEvent(clip);
		loopClip.initialize();
		loopClip.fire();
	}
	private byte[] readBytes(InputStream in) {
		try {
			BufferedInputStream buf = new BufferedInputStream(in);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int read;
			while ((read = buf.read()) != -1) {
				out.write(read);
			}
			in.close();
			return out.toByteArray();
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private void shutDownClips() {
		if (loopClip != null)
			loopClip.shutDown();
		if (loopStream != null)
			loopStream.shutDown();
	}
	
	public void loop(){
		
	}

	private void increaseGain(AudioStream audio) {
		float current = audio.getGain();
		if (current < 10.0f) {
			audio.setGain(current + 3.0f);
		}
	}

	private void decreaseGain(AudioStream audio) {
		float current = audio.getGain();
		if (current > -20.0f) {
			audio.setGain(current - 3.0f);
		}
	}

}