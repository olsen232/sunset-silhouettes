import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Alphanize {

  public static void main(String[] args) throws Exception {
    String name = args[0];
    BufferedImage img = ImageIO.read(new File(name));
    for (int x = 0; x < img.getWidth(); x++) {
      for (int y = 0; y < img.getHeight(); y++) {
        int argb = img.getRGB(x, y);
        int val = argb & 0xff;
        argb = (0xff - val) << 24;
        img.setRGB(x, y, argb);
      }
    }
    name = "out." + name;
    ImageIO.write(img, "png", new File(name));
  }
}
