// TODO : Correct the dead code
// TODO : Get to know what  dead code is

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main{
	
	private static ArrayList<Album> albums = new ArrayList<Album>();
	private static Scanner scanner = new Scanner(System.in);
	private static Playlist playlist = new Playlist();
	private static ListIterator<Song> songsIterator = playlist.getSongs().listIterator();
	
	public static void main(String[] args){
		
		printActions();
		
		boolean quit = false;
		int action = 0;
		
		while(!quit){
			
			System.out.println("Please enter a menu option :");
			action = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(action){
			
			case 0 :
				quit = true;
				break;
				
			case 1 :
				addANewAlbum();
				break;

			case 2 :
				addASongToASpeceficAlbum();
				break;

			case 3 :
				addASongToThePlaylist();
				break;

			case 4 :
				listAllTheSongsInAllAlbums();
				break;

			case 5 :
				listAllAlbumNames();
				break;

			case 6 :
				listAllSongsInASpeceficAlbum();
				break;

			case 7 :
				listAllSongsFromThePlaylist();
				break;
			case 8 :	
				removeASongFromAnAlbum();
				break;
			case 9 :
				removeASongFromThePlaylist();
				break;
			
			case 10 :
				removeAnAlbum();
				break;
				
			case 11 :
				skipForward(songsIterator);
				break;
			
			case 12 :
				skipBackwards();
				break;

			case 13 :

				break;

			}
		}
	}
	
	public static boolean skipBackwards(){
		
		//return playlist.skipBackwards();
		return true;
		
	}
	
	public static boolean skipForward(ListIterator<Song> songsIterator){
		
		
		if(songsIterator.hasNext()){
			String current = songsIterator.next().getName();
			songsIterator.next();
			System.out.println(current);
			System.out.println("Passing to the next one");
			return true;
		} else {
			System.out.println("End of the list !");
			return false;
		}
		
	}
	
	public static boolean removeAnAlbum(){
		
		System.out.println("Please enter the name of the album you would like to remove");
		String albumName = scanner.nextLine();
		
		int albumPosition = findAlbum(albumName);
		
		if(albumPosition >= 0){
			albums.remove(albumPosition);
			return true;
		}
		
		return false;
		
	}

	
	public static boolean removeASongFromThePlaylist(){
		
		System.out.println("Please enter the title you would like to remove");
		String title = scanner.nextLine();
		
		return playlist.removeASong(title);
		
	}
	
	public static void listAllSongsFromThePlaylist(){
		
		playlist.listAllSongs();
		
	}
	
	public static boolean addASongToThePlaylist(){
		
		// We must retrieve the song from each album and then add it to the playlist
		
		System.out.println("Please enter the name of chosen song");
		String title = scanner.nextLine();
		
		int songPosition = findSong(title);
		int albumPosition = findAlbumPositionOfSpeceficSong(title);
		
		
		if(songPosition >= 0){
			
			Album album = albums.get(albumPosition);
			Song song = album.getSongs().get(songPosition);
			
			return playlist.addANewSong(song);
			
		}
				
		
		System.out.println("Song already int he playlist");
		return false;
		
		
	}
	
	public static int findAlbumPositionOfSpeceficSong(String title){
		
		for(int i = 0 ; i < albums.size() ; i++){
			
			Album album = albums.get(i);
			
			int songPosition = album.findSong(title);
			
			if(songPosition >= 0){
				
				System.out.println("Found album position");
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	public static boolean removeASongFromAnAlbum(){
		System.out.println("Please enter the album name :");
		String albumName = scanner.nextLine();
		
		int albumPosition = findAlbum(albumName);
		
		System.out.println("Please enter the song title :");
		String title = scanner.nextLine();
		
		int songPosition = findSong(title);
		
		if(songPosition >= 0){
			
			Album album = albums.get(albumPosition);
				
			album.removeSong(songPosition);
			return true;
		}
		
		System.out.println("The album or the song might be missing off the file");
		return false;
	}
		
	public static int findSong(String title){
		
		for(int i = 0; i < albums.size() ; i++){
			Album album = albums.get(i);
								
			return album.findSong(title);
		}
		
		return -1;
	}
	
	public static void listAllSongsInASpeceficAlbum(){
		
		System.out.println("Please enter the album name :");
		String albumName = scanner.nextLine();
		
		int albumPosition = findAlbum(albumName);
		
		if(albumPosition >= 0){
			Album album = albums.get(albumPosition);
			
			album.listAllSongs();
		}
		
		
	}
	
	public static void listAllTheSongsInAllAlbums(){
		
		System.out.println("There are " + albums.size() + " albums as follows.");
		
		for(int i = 0; i < albums.size() ; i++){
			
			Album album = albums.get(i);
			
			album.listAllSongs();
			
		}
		
	}
	
	public static boolean addASongToASpeceficAlbum(){
		
		System.out.println("Please enter the name of the song you want to add :");
		String title = scanner.nextLine();

		System.out.println("Please enter the duration of the song you want to add :");
		double duration = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Please enter the name of the specefic album :");
		String albumName = scanner.nextLine();
		
		// Search for the album if exists construct the song and add it to it
		// if it does not exist return false
		int albumPosition = findAlbum(albumName);
		
		// If found
		if(albumPosition >= 0){
			System.out.println("Album found !");
			//Then construct the song
			// Add the song to the album on position albumPosition
			Song song = new Song(title, duration);			
			
			Album album = albums.get(albumPosition);
			album.addSong(song);
			return true;
		}
		
		System.out.println("Album not found !");
		return false;
		
	}
	
	public static int findAlbum(String albumName){
		
		for(int i = 0; i < albums.size() ; i++){
			if(albumName.equals(albums.get(i).getAlbumName())){
				return i;
			}
		}
		
		return -1;
		
	}
	
	public static void listAllAlbumNames(){
		
		for(int i = 0; i < albums.size() ; i++){
			System.out.println("Album #" + (i + 1) + " is called " + albums.get(i).getAlbumName());
		}
		
	}
	
	public static void addANewAlbum(){
		
		System.out.println("Please enter the album name");
		String albumName = scanner.nextLine();
		
		Album album = new Album(albumName);
		
		albums.add(album);
		
	}
	
	public static void printActions(){
		
		System.out.println(" 0 : Quit music player");
		System.out.println(" 1 : Add a new album");
		System.out.println(" 2 : Add a song to a specefic album");
		System.out.println(" 3 : Add a song to the playlist");
		System.out.println(" 4 : List all songs in all album");
		System.out.println(" 5 : List all album names");
		System.out.println(" 6 : List all songs in a specefic album");
		System.out.println(" 7 : List all songs in the playlists");
		System.out.println(" 8 : Remove a song from an album");
		System.out.println(" 9 : Remove a song from the playlist");
		System.out.println(" 10 : Remove an album");
		System.out.println(" 11 : Skip forward");
		System.out.println(" 12 : Skip backwards");
		System.out.println(" 13 : Replay the current song");
		
	}
}