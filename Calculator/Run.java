package spring_inter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    final static String INPUT_FILE_PATH = "res\\intput_1_2_3.txt";
    final static String OUTPUT_FILE_PATH = "res\\output_1_2_3.txt";
    static List<String> expressions = new ArrayList<>();
    static List<String> results = new ArrayList<>();
    static String inLine;

    public static void main (String [] arg){
        parsing(reading(INPUT_FILE_PATH));
        writing();
    }

    private static List<String> reading(String filePath){
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(filePath));
            while ((inLine = in.readLine()) != null) {
                expressions.add(inLine);
            }
            in.close();
        } catch(Exception e) {e.printStackTrace();}
            return expressions;
    }

    private static void parsing(List<String> expressions){
        List<String> expression = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)|((?:sin|cos|tg)|[√]|\\(|\\)|\\+|\\-|\\*|\\/|\\^|\\%|\\n|\\r)");
        ChangeTo changeTo = new ChangeTo();
        results = changeTo.getResults();
        for (String s: expressions) {
            Matcher matcher = pattern.matcher(s);
            expression.clear();
            while (matcher.find()) {
                expression.add(matcher.group().trim());
                //System.out.println(matcher.group());
            }
            changeTo.changeToRpn(expression);
            /*for (String st : expression){
                System.out.print(st);
            }
            System.out.println();*/
        }

    }
    private static void writing()  {
        File file = new File (OUTPUT_FILE_PATH);

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            int i = 0;
            for (String s : expressions){
                writer.write(s + " = "+ results.get(i)+ "\n");
                writer.flush();
                i++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
