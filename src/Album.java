import java.util.ArrayList;


public class Album{
	
	private String albumName;
	private ArrayList<Song> songs;
	
	public Album(String albumName){
		
		this.albumName = albumName;
		this.songs = new ArrayList<Song>();
	}
	
	public Album(String albumName, ArrayList<Song> songs){
		
		this.albumName = albumName;
		this.songs = new ArrayList<Song>();
		
	}
	
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	public void addSong(Song song) {
		
		this.songs.add(song);
		
	}

	public void listAllSongs() {
		
		for(int i = 0 ; i < this.songs.size() ; i++){
			Song song = this.songs.get(i);
			System.out.println("Song #" + (i + 1) + " ---> " + song.getName());
		}
		
	}

	public int findSong(String title) {
		
		for(int i = 0; i < this.songs.size() ; i++){
			
			Song song = this.songs.get(i);
			
			if(song.getName().equals(title)){
				System.out.println("Found song !");
				return i;
			}
			
		}
		
		return -1;
		
	}

	public void removeSong(int songPosition) {
		
		this.songs.remove(songPosition);
		
	}	
}