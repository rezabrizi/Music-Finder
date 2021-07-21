
public class Song {

	private String name; 
	private String artist; 
	private String date; 
	
	public Song()
	{
		name = null; 
		artist = null; 
		date = null; 
	}
	
	public Song(String name, String artist, String date)
	{
		this.name = name; 
		this.artist = artist; 
		this.date = date; 
	}
	
	public String getName()
	{
		return name; 
	}
	
	public String getArtist()
	{
		return artist; 
	}
	
	public String getDate()
	{
		return date; 
	}
	
	public void setName(String name)
	{
		this.name = name; 
	}
	
	public void setArtist(String artist)
	{
		this.artist = artist; 
	}
	
	public void setDate(String date)
	{
		this.date = date; 
	}
	
	public boolean equals (Object o)
	{
		Song other = (Song) o; 
		if (this.name.equals(other.name) && this.artist.equals(other.artist))
			return true; 
		return false; 
	}
	
	public String toString ()
	{
		return name + " " + artist + " " + date; 
	}
	
	public String saveToFile()
	{
		return name + "\n" + artist + "\n" + date + "\n";
	}
	
}
