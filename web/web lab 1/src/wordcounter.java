import java.util.*;
import java.io.Serializable;

public class wordcounter implements Result, Serializable {
    private String[] strings;
    private String output;


    wordcounter(String name){
        this.strings = name.split(",");
        calculatewords();
    }
    wordcounter(String[] name){
        this.strings = name.clone();
        for(String string: strings){
            System.out.println(string);
        }
        calculatewords();

    }
    wordcounter(ArrayList<String> name){
        this.strings = (String[]) name.toArray();
        calculatewords();
    }

    private void calculatewords(){
        HashMap<String, Integer> wordcounter = new HashMap<>();
        for(String word : this.strings){
            if(wordcounter.containsKey(word)){
                wordcounter.put(word,wordcounter.get(word)+1);
            }else{
                wordcounter.put(word, 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> entry : wordcounter.entrySet()){
            if(entry.getValue()>1){
                result.append("\nWord '").append(entry.getKey()).append("' Repeats ").append(entry.getValue()).append(" times.");
            }
        }
        this.output = String.valueOf(result);
    }



    public String getResult() {
        return this.output;
    }
}
