package com.tts.xiaoliji.intf.base.random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class TokenImgGenerator {
	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public static byte[] createPic(String token) throws IOException {
		int width = 15 * token.length() + 8;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, 1);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(new Color(217, 217, 255));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Comic San MS", 0, 18));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawOval(x, y, x + xl, y + yl);
		}
		for (int i = 0; i < token.length(); i++) {
			char key = token.charAt(i);
			String rand = String.valueOf(key);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 15 * i + 6, 16);
		}
		g.dispose();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(image, "jpeg", os);

		return os.toByteArray();
	}
}
