import java.util.ArrayList; 

public class SongList {

	private ArrayList <Song> music;
	
	public SongList()
	{
		music = new ArrayList<Song>();
	}
	
	public void addSong (Song song)
	{
		music.add(song);
	}
	
	public boolean removeSong (Song song)
	{
		if (music.indexOf(song) != -1)
		{
			music.remove((music.indexOf(song)));
			return true;
		}
		return false; 
	}
	//returns the name of artists with the song title song 
	public String findArtist (String song)
	{
		ArrayList <String> name = new ArrayList <String>(); 
		for (Song e: music)
			if (e.getName().equals(song))
				name.add(e.getArtist());
		String results = "";
		for (int i = 0; i < name.size(); i++)
		{
			if (name.size()-1 == i)
			{
				results += name.get(i) +".";
			}
				
			else
			{
				results += name.get(i) + ", "; 
			}
				
		}
		return results; 
	}
	
	//returns all the songs of an artist 
	public String allSongs (String artist)
	{
		ArrayList <String> songs = new ArrayList <String>();
		for (Song e: music)
			if(e.getArtist().equals(artist))
				songs.add(e.getName());
		String results = "";
		for (int i = 0; i < songs.size(); i++)
		{
			if (music.size()-1 == i)
			{
				results += music.get(i) +".";
			}
				
			else
			{
				results += music.get(i) + ", ";
			}
		}
		return results; 
	}
	
	public boolean findSong (Song s)
	{
		for (Song e: music)
			if (e.equals(s))
				return true; 
		return false; 
	}
	
	public String toString()
	{
		String out = ""; 
		for (Song e: music)
			out += e.toString(); 
		return out; 
	}
	
	public String saveToFile()
	{
		String out = "";
		for (Song e: music)
		
			out+= e.saveToFile();
		return out;
	}
	public int size()
	{
		return music.size();
	}
}
