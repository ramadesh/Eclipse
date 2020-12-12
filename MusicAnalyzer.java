import java.io.*;
import java.util.*;
/**
 * Music Analyzer
 *
 * methods to work with artists and songs and give the user info
 *
 *
 * @author Rama Deshpande, CS180 Merge
 * @version Oct 30, 2020
 *
 */

public class MusicAnalyzer extends Object {
    private static Artist[] artists;
    private static MusicAnalyzer musicAnalyzer;
    private static Song[] songs;

    public MusicAnalyzer()
    {
        artists = new Artist[10];
        songs = new Song[10];
    }

    public int addArtist(Artist artist)
    {
        //System.out.println("The artist entered: " + artist.getArtistName());
        int originalLength = artists.length;
        boolean added = false;
        for (int i = 0; i < artists.length; i++)
        {
            if (artists[i] == null)
            {
                artists[i] = artist;
                added = true;
                return i;
            }
            if (artists[i].getArtistName().equals(artist.getArtistName()))
            {
                return -1;
            }

        }
        if (added == false)
        {
            Artist[] artists2 = new Artist[originalLength * 2];
            System.arraycopy(artists, 0, artists2, 0, artists.length);
            artists2[originalLength] = artist;
            artists = artists2;
            added = true;
            return originalLength;
        }
        return -2;
    }

    public void addSong(Song song)
    {
        int originalLength = songs.length;
        boolean added = false;

        for (int i = 0; i < songs.length; i++)
        {
            if (songs[i] == null)
            {
                songs[i] = song;
                added = true;
                return;
            }
            if (songs[i].getSongName().equals(song.getSongName()))
            {
                return;
            }

        }
        if (added == false)
        {
            Song[] songs2 = new Song[originalLength * 2];
            System.arraycopy(songs, 0, songs2, 0, songs.length);
            songs2[originalLength] = song;
            songs = songs2;
            added = true;
            return;
        }
    }

    public void countSongsByArtist(String artistName)
    {
        int counter = 0;
        for (Song theSong : songs)
        {
            if (theSong == null)
            {
                break;
            }
            if (String.valueOf(theSong.getMainArtist().getArtistName()).equals(artistName))
            {
                counter++;
            }
        }
        System.out.println("The artist you entered has recorded " + counter + " songs");
    }

    public void exportByArtist(Scanner scanner, String filename)
    {
        File f = new File(filename);
        if (f.exists())
        {
            System.out.print("The file you entered already exists. Continuing will overwrite it. ");
            System.out.println("Enter 1 if this is okay, or 2 to exit.");
            int override = scanner.nextInt();
            scanner.nextLine();
            while (override != 1 && override != 2)
            {
                System.out.println("Invalid choice. Try again.");
                override = scanner.nextInt();
            }
            if (override == 2)
            {
                return;
            }
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f, false);
            PrintWriter pw = new PrintWriter(fos);
            int artistsNullIndex = 0;
            int artistSongsNullIndex = 0;
            for (int i = 0; i < artists.length; i++)
            {
                if (artists[i] == null)
                {
                    artistsNullIndex = i;
                }
            }
            if (artistsNullIndex == 0)
            {
                artistsNullIndex = artists.length;
            }
            for (int j = 0; j < artistsNullIndex; j++)
            {
                if(artists[j] == null)
                {
                    continue;
                }
                Song[] theArtistSongs = artists[j].getArtistSongs();
                for (int k = 0; k < theArtistSongs.length; k++)
                {
                    if (theArtistSongs[k] == null)
                    {
                        artistSongsNullIndex = k;
                        break;
                    }
                }
                boolean printArtistName = false;
                for (int l = 0; l < theArtistSongs.length; l++)
                {
                    if (printArtistName == false)
                    {
                        pw.print(artists[j].getArtistName() + "\t");
                        printArtistName = true;
                    }
                    if(theArtistSongs[l] == null)
                    {
                        continue;
                    }
                    if (artistSongsNullIndex != 0 && l == artistSongsNullIndex - 1)
                    {
                        pw.println(theArtistSongs[l].getSongName());
                    } else if (artistSongsNullIndex != l) {
                        pw.print(theArtistSongs[l].getSongName() + ", ");
                    }

                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void findArtistGenre(String artistName)
    {
        boolean artistFound = false;
        for (Artist theArtist : artists)
        {
            if (theArtist == null)
            {
                break;
            }
            if (theArtist.getArtistName().equals(artistName))
            {
                artistFound = true;
                System.out.println("The artist you entered has a genre of " + theArtist.getArtistGenre());
            }
        }
        if (artistFound == false)
        {
            System.out.println("The artist you entered couldn't be found!");
        }
    }

    public void findArtistsAndFeatures(String artistName, String[] features)
    {
        boolean artistFound = false;
        boolean arrayNotEmpty = false;
        for (Artist theArtist : artists)
        {
            if (theArtist != null && theArtist.getArtistName().equals(artistName))
            {
                artistFound = true;
                Song[] mainSongs = theArtist.getArtistSongs();
                for (Song mainSong : mainSongs)
                {
                    if (mainSong != null)
                    {
                        arrayNotEmpty = true;
                    }
                }
                if (arrayNotEmpty == false)
                {
                    System.out.println("The artist has no songs!");
                    return;
                }
                int nullIndex = 0;
                for (int i = 0; i < mainSongs.length; i++)
                {
                    if (mainSongs[i] == null)
                    {
                        nullIndex = i;
                    }
                }
                if (nullIndex == 0)
                {
                    nullIndex = mainSongs.length;
                }
                int k = 0;
                int songCounter = 0;
                for (int j = 0; j < nullIndex; j++)
                {
                    if (mainSongs[j] == null)
                    {
                        continue;
                    }
                    if (features.length == 0 && mainSongs[j].getAccompanyingArtists().length == 0)
                    {
                        songCounter++;
                        System.out.println("(" + songCounter + ") " + mainSongs[j].getSongName());
                    }
                    Artist[] songFeatures = mainSongs[j].getAccompanyingArtists();

                    for (int l = 0; l < songFeatures.length; l++)
                    {
                        if (k >= features.length)
                        {
                            break;
                        }
                        if (features[k].equals(songFeatures[l].getArtistName()))
                        {
                            if (k == features.length - 1)
                            {
                                songCounter++;
                                System.out.println("(" + songCounter + ") " + mainSongs[j].getSongName());
                            }
                            //k++;
                        }
                    }
                }
            }
        }
        if (artistFound == false)
        {
            System.out.println("The artist has no songs!");
            return;
        }
    }

    public void findMainArtistOnSong(String songName)
    {
        boolean songFound = false;
        for (Song theSong : songs)
        {
            if (theSong == null)
            {
                break;
            }
            if (theSong.getSongName().equals(songName))
            {
                System.out.print("The song you entered was recorded by ");
                System.out.println(theSong.getMainArtist().getArtistName());
                songFound = true;

            }
        }
        if (songFound == false)
        {
            System.out.println("The song you entered couldn't be found!");
        }
    }
    public void findSongLength(String songName)
    {
        boolean songFound = false;
        for (Song theSong : songs)
        {
            if (theSong == null)
            {
                break;
            }
            if (theSong.getSongName().equals(songName))
            {
                songFound = true;
                System.out.print("The song you entered has a length of ");
                System.out.println(theSong.getSongLengthInMinutesAndSeconds());
            }
        }
        if (songFound == false)
        {
            System.out.println("The song you entered couldn't be found!");
        }
    }

    public void listFeaturesOnSong(String songName)
    {
        boolean found = false;
        for (int i = 0; i < songs.length; i++)
        {
            if (songs[i] == null)
            {
                break;
            }
            if (songs[i].getSongName().equals(songName))
            {
                found = true;
                if (songs[i].getAccompanyingArtists().length > 0)
                {
                    Artist[] features = new Artist[songs[i].getAccompanyingArtists().length];
                    features = songs[i].getAccompanyingArtists();
                    for (int j = 0; j < features.length; j++)
                    {
                        System.out.println("(" + (j + 1) + ") " + features[j].getArtistName());
                    }
                } else
                {
                    System.out.println("This song doesn't have any features!");
                }
            }
        }
        if (found == false)
        {
            System.out.println("The song you entered couldn't be found!");
        }
    }

    public void listSongsByArtist(String artistName)
    {
        int counter = 0;
        boolean artistFound = false;
        for (Artist theArtist : artists)
        {
            if (theArtist == null)
            {
                break;
            }
            if (theArtist.getArtistName().equals(artistName))
            {
                artistFound = true;
                Song[] theArtistSongs = theArtist.getArtistSongs();
                for (Song theSong : theArtistSongs)
                {
                    if (theSong != null)
                    {
                        counter++;
                        System.out.println("(" + counter + ") " + theSong.getSongName());
                    }
                }
            }
        }
        if (artistFound == false)
        {
            System.out.println("The artist you entered couldn't be found!");
        }
    }

    public static void main(String[] args) throws InvalidSongFormatException
    {
        Scanner scanner = new Scanner(System.in);
        performInitialization(scanner);
        int menuChoice = 0;
        while (menuChoice != 9)
        {
            showMenu();
            menuChoice = scanner.nextInt();
            scanner.nextLine();
            switch(menuChoice) {
                case 1:
                    System.out.println("What is the name of the artist you want all the songs by?");
                    String case1 = scanner.nextLine();
                    musicAnalyzer.listSongsByArtist(case1);
                    break;
                case 2:
                    System.out.println("What is the name of the song you want the features of?");
                    String case2 = scanner.nextLine();
                    musicAnalyzer.listFeaturesOnSong(case2);
                    break;
                case 3:
                    System.out.println("What is the name of the song you want the main artist of?");
                    String case3 = scanner.nextLine();
                    musicAnalyzer.findMainArtistOnSong(case3);
                    break;
                case 4:
                    System.out.println("What is the name of the artist?");
                    String case4 = scanner.nextLine();
                    musicAnalyzer.countSongsByArtist(case4);
                    break;
                case 5:
                    System.out.println("What is the name of the song?");
                    String case5 = scanner.nextLine();
                    musicAnalyzer.findSongLength(case5);
                    break;
                case 6:
                    System.out.println("What is the name of the artist?");
                    String case6 = scanner.nextLine();
                    musicAnalyzer.findArtistGenre(case6);
                    break;
                case 7:
                    System.out.print("What is the name of the main artist? ");
                    System.out.print("How many features are there? ");
                    System.out.println("Enter the artist names, each one on its own line.");
                    String case7 = scanner.nextLine();
                    int numFeatures = scanner.nextInt();
                    scanner.nextLine();
                    String[] features = new String[0];
                    if (numFeatures != 0)
                    {
                        features = new String[numFeatures];

                        for (int f = 0; f < numFeatures; f++)
                        {
                            features[f] = scanner.nextLine();
                        }

                    }
                    musicAnalyzer.findArtistsAndFeatures(case7, features);
                    break;
                case 8:
                    System.out.println("What is the filename you want to export to? Be sure to include the extension.");
                    String case8 = scanner.nextLine();
                    musicAnalyzer.exportByArtist(scanner, case8);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("You entered something other than a number, try again!");
                    showMenu();
                    menuChoice = scanner.nextInt();
                    scanner.nextLine();
            };
        }
        if (menuChoice == 9)
        {
            System.out.println("Exiting the Music Analyzer");
        }
    }

    public static void performInitialization(Scanner scanner) throws InvalidSongFormatException
    {
        musicAnalyzer = new MusicAnalyzer();
        int index = 0;
        System.out.println("What is the name of the song file you'd like to read?");
        String songFileName = scanner.nextLine();
        if (songFileName.indexOf(".") == -1)
        {
            throw new InvalidSongFormatException();
        } else
        {
            for (int i = 0; i < songFileName.length(); i++)
            {
                if (songFileName.indexOf(".") == i)
                {
                    index = i;
                }
            }
            String fileExt = songFileName.substring(index + 1, songFileName.length());
            if (fileExt.length() < 1)
            {
                throw new InvalidSongFormatException();
            } else
            {
                File f = new File(songFileName);
                if (f.exists() == false)
                {
                    throw new InvalidSongFormatException();
                } else
                {
                    processFile(songFileName);
                }
            }
        }

    }

    public static void processFile(String filename) throws InvalidSongFormatException
    {
        File f = new File(filename);
        FileReader fr = null;
        int indexBracket = 0;
        String partOfLine = "";
        int commaCounter = 0;
        String lineWithoutBrackets = "";
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bfr = new BufferedReader(fr);
        String line = null;
        try {
            line = bfr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            try {
                //System.out.println(line);
                if (line.indexOf("[") == -1)
                {
                    throw new InvalidSongFormatException();
                }
                indexBracket = line.indexOf("[");

                partOfLine = line.substring(0, indexBracket);
                //System.out.println("PartOfLIne: " + partOfLine);
                commaCounter = partOfLine.split(", ").length;
                //System.out.println("commas: " + commaCounter);
                if (commaCounter != 4)
                {
                    throw new InvalidSongFormatException();
                }
                lineWithoutBrackets = line.substring(0, indexBracket) + line.substring(indexBracket + 1, line.length() - 1);
                //System.out.println(lineWithoutBrackets);
                String[] fileInfo = lineWithoutBrackets.split(", ");
                //System.out.println("Array split: " + Arrays.toString(fileInfo));
                Artist theArtist = new Artist(fileInfo[1]);

                //System.out.println("theArtist: " + theArtist.getArtistName());
                for (Artist artiste : artists)
                {

                    if (artiste != null && artiste.getArtistName().equals(fileInfo[1]))
                    {
                        theArtist = artiste;
                    }

                }
                musicAnalyzer.addArtist(theArtist);
                Artist [] accompanying = new Artist[fileInfo.length - 4];
                int j = 0;
                for (int i = 4; i < fileInfo.length; i++)
                {
                    Artist artist = new Artist(fileInfo[i]);
                    accompanying[j] = artist;
                    j++;
                }

                Song theSong = new Song(fileInfo[0],
                        Integer.parseInt(fileInfo[3]),
                        fileInfo[2],
                        theArtist,
                        accompanying);
                musicAnalyzer.addSong(theSong);
                theArtist.recordOwnSong(theSong);
                for (Artist a : accompanying)
                {
                    a.recordFeaturedSong(theSong);
                }
    			/*
    			boolean duplicate = false;
    			for (Artist ar : artists)
    			{
    				if (ar == null)
    				{
    					break;
    				}
    				if (ar.getArtistName().equals(theArtist.getArtistName()))
    				{
    					duplicate = true;
    					break;
    				}
    			}
    			if (duplicate == false)
    			{
    				musicAnalyzer.addArtist(theArtist);
    			}
    			*/
                line = bfr.readLine();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showMenu() {
        System.out.println("****************");
        System.out.println("Music Analyzer");
        System.out.println("(1) List all songs by an artist");
        System.out.println("(2) List all features on a song");
        System.out.println("(3) List the main artist of a song");
        System.out.println("(4) How many songs does this artist have?");
        System.out.println("(5) What is the length of a specific song?");
        System.out.println("(6) What genre does this artist fall under?");
        System.out.println("(7) What are the songs which are by a specific artist featuring other specific artists?");
        System.out.println("(8) Export all artist data by artist");
        System.out.println("(9) Exit");
        System.out.println("****************");

    }

}
