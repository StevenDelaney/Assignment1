package imageprocessing;


import java.awt.Color;
import edu.princeton.cs.introcs.Picture;


public class ConnectedComponentImage 
{
	private String imageLocation;
	Picture picture;

	public ConnectedComponentImage(String fileLocation) 
	{
		picture = getPicture(fileLocation);
		this.imageLocation = fileLocation;    
	}                     
	
	public Picture getPicture(String fileLoc) 
	{
		Picture getPicture = new Picture(fileLoc);
		return getPicture;
	}

	/**
	 * Returns a binary version of the original image, called from image through grayscale.
	 * 
	 * @return a picture object with all pixels set to either black or white
	 */

	public Picture binaryComponentImage() 
	{
		Picture pic = new Picture(greyScale()); 

		
		int width = pic.width();
		int height = pic.height();

		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
				Color c = pic.get(x, y);

				if (Luminance.lum(c) >= 128)
				{
					pic.set(x, y, Color.BLACK); 
				} 
				else 
				{
					pic.set(x, y, Color.WHITE); 
				}
			}
		}

		return pic;
	}


	/**
	 * a method to turn an image to grayscale, called from imageLocation.
	 * 
	 * @return picture called in grayscale
	 */

	public Picture greyScale()
	{
		Picture pic = new Picture(imageLocation); 
		int width = pic.width();
		int height = pic.height();
		
		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
				Color color = pic.get(x, y);
				Color gray = Luminance.toGray(color); 
				pic.set(x, y, gray);
			} 
		}
		return pic;
	}
	
	
	/**
	 * Method to return the original Image called.
	 * @return Original Image
	 */
	public Picture originalImage()
	{
		Picture pic = new Picture(picture);
	
		pic.show();
		
		return pic;
	
	}
}