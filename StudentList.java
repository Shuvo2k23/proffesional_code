import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        //for early exit
		if(args==null || args.length!=1){
			System.out.println(Contstants.Wrong_Argument);
			return;
		}
        //file read
        String readLine = fileReader(Contstants.STUDENT_LIST);
//		Check arguments
        if (args[0].equals(Contstants.ShowAll)) {
            System.out.println(Contstants.Loading);
            try {
                String students[] = readLine.split(Contstants.SplitAt);
                for (String student : students) {
                    System.out.println(student);
                }
            } catch (Exception e) {
            }
            System.out.println(Contstants.Loaded);
        } else if (args[0].equals(Contstants.ShowRandom)) {
            System.out.println(Contstants.Loading);
            try {

                String students[] = readLine.split(Contstants.SplitAt);
                Random random = new Random();
                int randomInt = random.nextInt(students.length);
                System.out.println(students[randomInt].trim());
            } catch (Exception e) {

            }
            System.out.println(Contstants.Loaded);
        } else if (args[0].contains(Contstants.AddEntry)) {
            System.out.println(Contstants.Loading);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        			            new FileWriter(Contstants.STUDENT_LIST, true));
                String substring = args[0].substring(1);
                DateFormat dateFormat = new SimpleDateFormat(Contstants.Date_Format);
                String formatted = dateFormat.format(new Date());
                bufferedWriter.write(", " + substring + "\nList last updated on " + formatted);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Contstants.Loaded);
        } else if (args[0].contains(Contstants.FindEntry)) {
            System.out.println(Contstants.Loading);
            try {
                String students[] = readLine.split(Contstants.SplitAt);
                String substring = args[0].substring(1);
                for (int idx = 0; idx < students.length ; idx++) {
                    if (students[idx].trim().equals(substring)) {
                        System.out.println(Contstants.Found_Massage);
                        break;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Contstants.Loaded);
        } else if (args[0].contains(Contstants.ShowCount)) {
            System.out.println(Contstants.Loading);
            try {
                String students[] = readLine.split(Contstants.SplitAt);
                System.out.println(students.length + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println(Contstants.Loaded);
        }
		else {
			System.out.println(Contstants.Wrong_Argument);
		}
    }
    public static String fileReader(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                                            new InputStreamReader(
                                            new FileInputStream(fileName)));
            return bufferedReader.readLine();
        }
        catch (Exception e){
            return null;
        }

    }

}