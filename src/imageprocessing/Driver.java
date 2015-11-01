package imageprocessing;
import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;


public class Driver
{

	
	/**
	 *Shows a menu system.
	 *Allows user to choose the specific image.
	 */
	
	public String mainMenu()
	{
		StdOut.println("Number of image you wish to process?");
		StdOut.println("1. Dots.");
		StdOut.println("2. Random Shapes.");
		StdOut.println("3. Crosses.");
		
		
		String imageChoice = "";
		int option = StdIn.readInt();
		while(option < 1 || option > 3)
		{
			StdOut.println("Invalid number, please choose between 1 and 3 only.");
			option = StdIn.readInt();
		}
		switch(option)
		{
			case 1: imageChoice = "images/Simple.png";
			break;
			case 2: imageChoice = "images/RandomShapes.png";
			break;
			case 3: imageChoice = "images/crosses.gif";
		}
		return imageChoice;
	}
	
	/**
	 * Runs App.
	 * 
	 */
	public static void main(String[] args)
	{
		Driver app = new Driver();
		int runMenu;
		do
		{
			String imageLoc = app.mainMenu();
			app.userChoice(imageLoc);
			StdOut.println("Please type 1 to restart and 0 to exit");
			runMenu = StdIn.readInt();
			while(runMenu != 1 && runMenu != 0)
			{
				StdOut.println("Not Valid. Re-enter option.");
				runMenu = StdIn.readInt();
			}
			if(runMenu == 0)
			{
				StdOut.println("Exiting...Goodbye");
				System.exit(0);
			}
		}
		while(runMenu == 1);
	}
	
	/**
	 * 
	 *Allows User to chose which process the image must undergo.
	 */
	
	public void userChoice(String iLocate)
	{
		ConnectedComponentImage image = new ConnectedComponentImage(iLocate);
		StdOut.println("Which Process?.");
		StdOut.println("1. Binarise Image");
		StdOut.println("2. Grayscale Image.");
		StdOut.println("3. Original Image.");
		int option = StdIn.readInt();
		while(option < 1 || option > 3)
		{
			StdOut.println("Invalid option, please choose between 1 and 3.");
			option = StdIn.readInt();
		}
		switch(option)
		
		{
			case 1: Picture picture = image.binaryComponentImage();
					picture.show();
			break;
			case 2: Picture picture3 = image.greyScale();
					picture3.show();
			break;
			case 3: picture  = image.originalImage();
			break;
		}
	}

}