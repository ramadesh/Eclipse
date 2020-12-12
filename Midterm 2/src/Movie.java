import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Movie {
	private ArrayList<String> movieList;
	public Movie()
	{
		movieList = new ArrayList<>();
	}
	public void readMoviesFromFile(String filename) throws UnsupportedMovieException
	{
		File f = new File(filename);
        if (!f.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
            	if (line.split(", ").length != 3)
            	{
            		throw new UnsupportedMovieException("Invalid format.");
            	}
                movieList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
	public void writeMoviesToFile(String filename)
	{
		File f = new File(filename);
        if (f.exists()) 
        {
            f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            for (String str : movieList)
            {
            	pw.println(str);
            	pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void addMovie(String title, String director, String releaseYear)
	{
		String mov = "" + title + ", " + director + ", " + releaseYear;
		movieList.add(mov);
	}
	
}
/*
public static void main(String[] args) throws UnsupportedMovieException
{
	Movie m = new Movie();
	m.readMoviesFromFile("Test.txt");
	m.addMovie("Gossip Girl", "DanSchinder", "2012");
	m.writeMoviesToFile("TestWrite.txt");
}
*/
