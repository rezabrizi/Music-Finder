import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.util.Date; 
import javax.swing.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Finder {

	private static SongList audio; 
	private static String filePath = ""; 
	private static final String saveFile = "//musix.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		audio = new SongList(); 
		filePath = JOptionPane.showInputDialog("Please put in the file path to save and load data: ") + saveFile;
		loadFile();
		boolean done = false; 
		while (!done)
		{
			String options = "1- Start Application" + "\n" + "2- Add Song" + "\n" 
			+ "3- Find Artist" + "\n" + "4- Open File" + "\n" + "5- Close File" + "\n" + "6- Close Program"; 
			String inputValue = JOptionPane.showInputDialog(options);
			int n = Integer.parseInt(inputValue);
			switch(n)
			{
			case 1: 
				break; 
			case 2: 
				addSong();
				break;
			case 3: 	
				findArtist();
				break;
			case 4: 
				openFile();
				break; 
			case 5: 
			case 6: 
				saveFile();
				done = true; 
				break; 
			}
		}
	}
	
	public static void addSong()
	{
		boolean editMore = true; 
		while (editMore)
		{
			JTextField field1 = new JTextField();
			JTextField field2 = new JTextField(); 
			Object [] message = 
				{
						"Title: ", field1, 
						"Artist(s): ", field2, 
				};
			int option = JOptionPane.showConfirmDialog
			(null, message, "Enter the following info"
			, JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION)
			{
				String title = field1.getText();
				String singer = field2.getText();
				Date d1 = new Date();
				Song music = new Song (title, singer, fixDate(d1));
				if (!audio.findSong(music))
				{
					audio.addSong(music);
					JOptionPane.showMessageDialog(null, "The song was added to the list");
				}
				else 
					JOptionPane.showMessageDialog(null, "The song already exists in the list");
			}
			else 
				System.out.println("no data");
			String  menu = "1 - Add" + "\n" + "2 - Done ";
        	String  inputValue = JOptionPane.showInputDialog(menu);
        	//out write a switch to evaluate the options -- following if would be in your switch
        	if (inputValue.equals("2"))
        		editMore = false;
			}
				
		}
	
	public static void findArtist() 
	{
		boolean editMore = true; 
		while (editMore)
		{
			JTextField field1 = new JTextField();
			Object [] message = 
				{
						"What is the name of the Song? ", field1
				};
			int option = JOptionPane.showConfirmDialog
			(null, message, "Find Artist"
			, JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION)
			{
				String title = field1.getText();
				JOptionPane.showMessageDialog(null, "These artists have these songs: " + audio.findArtist(title));
			}
			else 
				System.out.println("no data");
			String  menu = "1 - Add" + "\n" + "2 - Done ";
        	String  inputValue = JOptionPane.showInputDialog(menu);
        	//out write a switch to evaluate the options -- following if would be in your switch
        	if (inputValue.equals("2"))
        		editMore = false;
		}
	}
	
	public static String fixDate(Date d)
	{
		int day = d.getDate();
		int month = d.getMonth(); 
		int year = d.getYear()+1900; 
		return month + "/" + day + "/" + year; 
	}
	
	//creates a file on desktop if it doesn't exist. 
	public static void saveFile()
	{
		for (int i = 0; i <= audio.size()-1 ; i++)
		{
			BufferedWriter bw = null;
			try 
			{
				File f = new File (filePath);	
				FileWriter path = new FileWriter (f);
				bw = new BufferedWriter(path);
				bw.write(audio.saveToFile());
				bw.close();
			}
			catch (Exception e) {
				System.err.println(e);
			}	
		}
		
	}
	
	public static void loadFile()
	{
		Scanner data; 
		try 
		{
			File f = new File (filePath);
			if(!f.exists())
			{
				f.createNewFile();
			}
			else 
			{
				data = new Scanner (f);
				while (data.hasNextLine())
				{
					String title = data.nextLine();
					String artist = data.nextLine();
					String date = data.nextLine();
					Song newS = new Song (title, artist, date);
					audio.addSong(newS); 
				}
			}
		}
		 catch (IOException e)
        {
            System.out.println ("input read failed " + e);
        }
		
	}
	
	public static void openFile()

	{
		try
		{
			File f = new File (filePath);
			if (!Desktop.isDesktopSupported())
			{
				System.out.println("Not Supported");
				return; 
			}
			Desktop desktop = Desktop.getDesktop(); 
			desktop.open(f);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}


