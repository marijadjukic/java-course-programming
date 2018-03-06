package course2.week.two;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.*;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    public void update(String person){
        int index = names.indexOf(person);
        if (index == -1){
            names.add(person);
            counts.add(1);
        } else {
            int value = counts.get(index);
            counts.set(index, value + 1);
        }
    }
    public void  findAllCharacters(){
        names.clear();
        counts.clear();
        FileResource resource = new FileResource();
        for(String line : resource.lines()){
            int index = line.indexOf('.');
            if(index != -1){
                String person = line.substring(0,index);
                if(person.equals(person.toUpperCase()) && person.startsWith("SCENE")==false){
                    update(person);
                }
            }
        }
    }
    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that occurre more than " + num1 + " times and less than " + num2 + " times are: ");
        for (int i = 0; i < counts.size(); i++){
            if(counts.get(i)>= num1 && counts.get(i)<=num2){
                System.out.println(names.get(i) + counts.get(i));
            }
        }

    }

    @Test
    public void tester(){
        findAllCharacters();
        for(int i = 0; i < names.size(); i++){
            if(counts.get(i)>1){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10,15);
    }
}
