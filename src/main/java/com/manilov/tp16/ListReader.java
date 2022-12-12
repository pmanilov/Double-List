package com.manilov.tp16;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ListReader {
    public LinkedHashMap<String, ArrayList<String>> doubleLevelList = new LinkedHashMap<>();
    private String filename;

    public String getFilename() {
        return filename;
    }

    public ListReader() {
        filename = "/home/pavel/IdeaProjects/TP16/src/main/java/com/manilov/tp16/list.txt";
        ReadFromTextFile(filename);
    }

    public void ReadFromTextFile(String filename){
        try(FileReader reader = new FileReader(filename)) {
            Scanner inf = new Scanner(reader);
            String name = new String();
            ArrayList<String> secondLevelList = new ArrayList<>();
            int counter = 0;
            while(inf.hasNextLine()) {
                String line = inf.nextLine();
                if(line.charAt(0) == '*' && counter == 0) {
                    name = line.substring(1);
                    secondLevelList = new ArrayList<>();
                    counter++;
                }
                else if(line.charAt(0) == '*' && counter != 0){
                    doubleLevelList.put(name, secondLevelList);
                    name = line.substring(1);
                    secondLevelList = new ArrayList<>();
                }
                else
                    secondLevelList.add(line.substring(5));
            }
            doubleLevelList.put(name, secondLevelList);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public void add(int number, String value){
        if(number == 0 && !doubleLevelList.containsKey(value))
            doubleLevelList.put(value, new ArrayList<>());
        else{
            int i = 1;
            for (HashMap.Entry<String, ArrayList<String>> entry : doubleLevelList.entrySet()) {
                if(i == number){
                     entry.getValue().add(value);
                }
                i++;
            }
        }
    }

    public void loadToTextFile(String filename){
        try(FileWriter writer = new FileWriter(filename)) {
            for (HashMap.Entry<String, ArrayList<String>> entry : doubleLevelList.entrySet()) {
                writer.write("*"+entry.getKey()+"\n");
                for(String str: entry.getValue()){
                    writer.write("    *"+str+"\n");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        sb.append("<ul class=\"list\" id=\"list\">\n");
        for (HashMap.Entry<String, ArrayList<String>> entry : doubleLevelList.entrySet()) {
            sb.append("    <li class=\"span\">"+counter++ +". "+entry.getKey()+"\n<ul>\n");
            ArrayList<String> secondLevelList = entry.getValue();
            for(String name : secondLevelList)
                sb.append("        <li>"+name+"</li>\n");
            sb.append("</ul>\n</li>\n");
        }
        sb.append("</ul>\n");
        return sb.toString();
    }
}
