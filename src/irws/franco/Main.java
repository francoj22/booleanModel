package irws.franco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    //tokenization
    // split the sentectes removing the stopwords
    //
    /**
     * @document : Document to be evaluate
     */
    public static ArrayList<String>  tokenization(String document){
        StringTokenizer st= new StringTokenizer(document);
        ArrayList<String>wordsPerDoc=new ArrayList<>();
        while (st.hasMoreTokens()){
            wordsPerDoc.add(st.nextToken());
        }
        return wordsPerDoc;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader bReader= new BufferedReader(new FileReader(new File("C:/Users/Franco/IdeaProjects/booleanModel/src/irws/franco/Documents.txt")));
        String inputLine;
        int counterDoc=0;
        LinkedHashMap dictionary =new LinkedHashMap();
        while ((inputLine = bReader.readLine()) != null){

            ArrayList<String>wordsPerDoc = tokenization(inputLine);
            for(String temp:wordsPerDoc)
                System.out.println(temp);



        }



       // String document= "this is a test";
        //tokenization(document);
        //tokenization("hola");
        //System.out.println("HelloWord");// write your code here
    }
}
