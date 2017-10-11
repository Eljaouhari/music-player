import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist{
	
	private LinkedList<Song> songs;
	
	public Playlist(LinkedList<Song> songs) {
		super();
		this.songs = new LinkedList<Song>();
	}

	public Playlist() {
		super();
		this.songs = new LinkedList<Song>();
	}

	public LinkedList<Song> getSongs() {
		return songs;
	}

	public void setSongs(LinkedList<Song> songs) {
		this.songs = songs;
	}

	public boolean addANewSong(Song song) {
		
		return this.songs.add(song);		
		
	}

	public void listAllSongs() {
		ListIterator<Song> songsIterator = this.songs.listIterator();
		
		while(songsIterator.hasNext()){
			
			System.out.println(songsIterator.next().getName());
			
		}
	}

	public boolean removeASong(String title) {
		
		int position = findSong(title);
		
		if(position >= 0){
		
			this.songs.remove(position);
			return true;
		}
		
		return false;
	}
	
	public int findSong(String title){
		
		ListIterator<Song> songsIterator = this.songs.listIterator();
		
		while(songsIterator.hasNext()){
			
			if(songsIterator.next().getName().equals(title)){
				System.out.println("We have found the song in the playlist");
				return songsIterator.nextIndex() - 1;
			}
			
		}
		
		System.out.println("We couldn't find the song in the playlist");
		
		return -1;
		
	}

	
	
	

	public boolean skipBackwards(boolean isGoingForward) {

		ListIterator<Song> songsIterator = this.songs.listIterator();
		
		/*if(isGoingForward && songsIterator.hasPrevious()){
			
			songsIterator.previous();
		}*/
		
		if(songsIterator.hasPrevious()){
			System.out.println("Now playing --> " + songsIterator.previous().getName());
			return isGoingForward = false;
		}
		
		System.out.println("Start of the list !");
		return isGoingForward = true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}