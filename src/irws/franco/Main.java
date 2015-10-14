package irws.franco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * @document : Document to be evaluate
     *
     */
    public static ArrayList<String>  tokenization(String document){
        StringTokenizer st= new StringTokenizer(document);
        ArrayList<String>wordsPerDoc=new ArrayList<>();
        while (st.hasMoreTokens()){

            String token= removingWords(st.nextToken().toLowerCase());
            if (!token.isEmpty())
                wordsPerDoc.add(token);
        }
        return wordsPerDoc;

    }

    /**
     *
     * @param token
     * @return
     */

    public static String removingWords(String token){
        try{


            String tempToken=token;
            Pattern regex = Pattern.compile("[a-z][a-z]+[1-9]=");
            Matcher matcher = regex.matcher(tempToken);
            if (matcher.find()) {
                token = tempToken.replace(matcher.group(), "");

            }
            return token;

        }catch (Exception s){
            System.out.println(s);

        }
        return token.toLowerCase();

    }


    public static void main(String[] args) throws IOException{
        BufferedReader bReader= new BufferedReader(new FileReader(new File("C:/Users/Franco/IdeaProjects/booleanModel/src/irws/franco/Documents.txt")));
        BufferedReader bStopWords= new BufferedReader(new FileReader(new File("C:/Users/Franco/IdeaProjects/booleanModel/src/irws/franco/StopWords.txt")));
        String binputLineReader,inputbLineStopWords;
        int counterDoc=0;
        LinkedHashMap dictionary =new LinkedHashMap();
        ArrayList<String>wordsPerDoc,stopWordsList;
        //Reading the document to be evaluates
        while ((binputLineReader = bReader.readLine()) != null){

             wordsPerDoc= tokenization(binputLineReader);
            for(String temp:wordsPerDoc)
                System.out.println(temp);


        }
        //Stops Words to be evaluates
        while ((inputbLineStopWords = bStopWords.readLine()) != null){

            stopWordsList = tokenization(inputbLineStopWords);
            for(String temp:stopWordsList)
                System.out.println(temp);

        }



       // String document= "this is a test";
        //tokenization(document);
        //tokenization("hola");
        //System.out.println("HelloWord");// write your code here
    }
}
