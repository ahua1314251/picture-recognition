package pic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CutImage xx = new CutImage();
		xx.cut("image/cc.jpg", "image", 18, 33);
	    Color cc= new Color(255,255,255);
	    System.out.println(cc.getRGB());
	    cc= new Color(0,0,0);
	    System.out.print(cc.getRGB());
	    
	    Range range1= new Range(-5001045,-9805779);
	    Range range2= new Range(-1000000,-7283220);
	    Range range3= new Range(-2037185,-8473041);
	    Range range4= new Range(-2037185,-9958935);
	    Range range5= new Range(-10037185,-16777216);
	    Range range6= new Range(-2226658,-12229377);
	    
		printArgb("image/map_0_2.jpg", range3 );
	}
	
	/**
	 * 
	 * @param path
	 * @param max
	 * @param min
	 * @throws IOException
	 * 
	 * first: -9805779   -5001045
	 * 2      -7283220   -1000000    
	 * 3      -8473041   -2359358            
	 * 4      -9958935   -2037185
	 * 5      -16777216  -10037185
	 * 6      -12229377  -2226658

	 */

	public static void printArgb(String path,Range range) throws IOException
	{
		 
		BufferedImage source = ImageIO.read(new File(path));
		BufferedImage nbi=new BufferedImage(source.getWidth(),source.getHeight(),BufferedImage.TYPE_BYTE_BINARY);  
		int[][] array = new int[source.getWidth()][source.getHeight()];
		
		for(int i=0;i<source.getHeight();i++)
		{
			System.out.println();
			for(int j=0;j<source.getWidth();j++)
			{
				if(source.getRGB(j, i)>range.min&&source.getRGB(j, i)<range.max)
				{
					nbi.setRGB(j, i,  -16777216);
					 System.out.print(1);
				}
				else
				{
					nbi.setRGB(j, i, -1);
					 System.out.print(0);	
				}
			  //System.out.print(source.getRGB(j, i));	
			}
			 System.out.println();	
		}
		
		
		ImageIO.write(nbi, "JPEG", new File("image/gen.jpg"));
	}
	
	

	
}


class Range{
	Range(int max,int min){
		this.max=max;
		this.min=min;
	}
	int max;
	int min;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
}