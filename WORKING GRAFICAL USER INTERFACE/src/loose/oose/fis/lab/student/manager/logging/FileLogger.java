package loose.oose.fis.lab.student.manager.logging;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileLogger implements ILog{
	String name="";
	static String FILES;
	static FileWriter myWriter=null;
	public FileLogger(String FILE)
	{

	
	    FILES=FILE;
		File file = new File(FILE);
		boolean result;  
		try   
		{  
			result = file.createNewFile();  //creates a new file  
			if(result)      // test if successfully created a new file  
			{  
				System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
			}  
			else  
			{  
				System.out.println("File already exist at location: "+file.getCanonicalPath());  
			}  
		}   
			catch (IOException e)   
			{  
				e.printStackTrace();    //prints exception if any  
			}         
		  
		  

	    
	}
	public static void write (long x)
	{
	    try {
	    	String output;
	    	Long y=x;
	    	output=y.toString();
	        myWriter = new FileWriter(FILES,true);
	        myWriter.write(output+"\n");
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    
		  
	}
	
	public static void write (String str)
	{
	    try {
	        myWriter = new FileWriter(FILES);
	        myWriter.write((String) str);
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	public static void close() throws IOException
	{
		myWriter.close();
	}
	public static void write ()
	{
		
	}
}
