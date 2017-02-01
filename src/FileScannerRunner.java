import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by RdDvls on 2/1/17.
 */
public class FileScannerRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        File emancipation = new File("emancipation.txt");
        File lowerCaseARemoved = new File("lowerCaseARemoved.txt");
        try {
            removeLowerCaseA(emancipation);
            removeUpperCaseA(lowerCaseARemoved);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void removeLowerCaseA(File emancipation) throws IOException {
        Scanner fileScanner = new Scanner(emancipation);
        FileWriter fileWriter = new FileWriter("lowerCaseARemoved.txt");
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            if (line.contains("a")) {
                String[] lowerCaseARemoved = line.split("a");
                for (int counter = 0; counter < lowerCaseARemoved.length; counter++) {
//                    System.out.print(lowerCaseARemoved[counter]);
                    fileWriter.write(lowerCaseARemoved[counter]);
                }
            }
        }
        fileWriter.close();

    }

    public static void removeUpperCaseA (File lowerCaseARemoved)throws IOException{
        Scanner fileScanner = new Scanner(lowerCaseARemoved);
        FileWriter fileWriter = new FileWriter("upperCaseAndLowerCaseARemoved.txt");
        while (fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            if(line.contains("A")){
                String[] upperCaseARemoved = line.split("A");
                for(int counter = 0; counter < upperCaseARemoved.length; counter++){
                    fileWriter.write(upperCaseARemoved[counter]);
                    System.out.println(upperCaseARemoved[counter]);
                }
            }
        }
        fileWriter.close();
    }
}
