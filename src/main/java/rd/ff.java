package rd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ff {

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
File folder = new File("C:\\Users\\23319\\Downloads\\relandpricesongole");
File[] listOfFiles = folder.listFiles();

for (File file : listOfFiles) {
    if (file.isFile()) {
    String fileName = file.getName();
        //System.out.println(fileName);
     // Open the file
        FileInputStream fstream = new FileInputStream("C:\\Users\\23319\\Downloads\\relandpricesongole\\"+fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

          // Print the content on the console
        if(strLine.contains("Land abutting") ||
strLine.contains("Agricultural Land fit for H.S"))
        {
        strLine = strLine.split("\\.",2)[1];

        System.out.print(fileName.replace(".txt", "\t"));

        //System.out.println(strLine);

        String[] t = strLine.split("  +");
        System.out.print(t[1]+ "\t");
        System.out.print(t[2]+ "\t");
        System.out.print(t[3]+ "\t");
        System.out.print(t[4]+ "\t");



        System.out.println("");

        }


        }

        //Close the input stream
        br.close();
    }
}
}
}