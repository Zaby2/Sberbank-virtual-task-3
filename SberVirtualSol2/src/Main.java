import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        File file = new File("Sber.txt");
        List<String> str1 = new ArrayList<String>();
        List<String> str2 = new ArrayList<String>();
        //List<String> str3 = new ArrayList<String>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                str1.add(sc.nextLine());
            }
            str1.sort((Comparator.comparing((String str) -> str.split(";")[3])).thenComparing(str -> str.split(";")[1] ));

            for (int i = 0; i < str1.size(); i++) {
                str2 = List.of(str1.get(i).split(";"));
                List<String> str3 = new ArrayList<String>(str2);
                if(str3.size() == 5) {
                    str3.add("Неизвестно");
                }
                City ct = new City(str3.get(1), str3.get(2), str3.get(3), str3.get(4), str3.get(5));
                //System.out.println(i);
                ct.Output();

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
    }
}
