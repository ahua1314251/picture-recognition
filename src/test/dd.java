package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class dd {

    public void binaryImage() throws IOException{
	File file = new File("image/bbb.png");
	BufferedImage image = ImageIO.read(file);
	
	int width = image.getWidth();
	int height = image.getHeight();
	
	BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_BINARY
	for(int i= 0 ; i < width ; i++){
	    for(int j = 0 ; j < height; j++){
		int rgb = image.getRGB(i, j);
		grayImage.setRGB(i, j, rgb);
	    }
	}
	
	File newFile = new File("image/2722425974762424028.jpg");
	ImageIO.write(grayImage, "jpg", newFile);
    }
    
    public void grayImage() throws IOException{
	File file = new File("image/bbb.png");
	BufferedImage image = ImageIO.read(file);
	
	int width = image.getWidth();
	int height = image.getHeight();
	
	BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_GRAY
	for(int i= 0 ; i < width ; i++){
	    for(int j = 0 ; j < height; j++){
		int rgb = image.getRGB(i, j);
		grayImage.setRGB(i, j, rgb);
	    }
	}
	
	File newFile = new File("image/2722425974762424027.jpg");
	ImageIO.write(grayImage, "jpg", newFile);
    }
    
    public static void main(String[] args) throws IOException {
	dd demo = new dd();
	demo.binaryImage();
	demo.grayImage();
    }

}
