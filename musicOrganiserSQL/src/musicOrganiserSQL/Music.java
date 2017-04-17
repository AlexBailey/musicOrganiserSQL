package musicOrganiserSQL;

public class Music {

	private int id;
	private String artist;
	private String track;
	private String album;
	private String genre;
	private String format;
	
	public Music(int ID, String Artist, String Track, String Album, String Genre, String Format)
	{
		this.id = ID;
		this.artist = Artist;
		this.track = Track;
		this.album = Album;
		this.genre = Genre;
		this.format = Format;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public String getTrack()
	{
		return track;
	}
	
	public String getAlbum()
	{
		return album;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public String getFormat()
	{
		return format;
	}
}
