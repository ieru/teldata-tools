/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.commons;

import com.uah.items.PostRating;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class FileRProcessor {
    
    private List<String> fields;

    
    public FileRProcessor() {
        
    }
    
    public void initFileRFields(){
        fields = new ArrayList();
        fields.add("courseid");
        fields.add("forumid");
        fields.add("postid");
        fields.add("rating");
        fields.add("roleid");
        fields.add("rolename");
        fields.add("scaleid");
        fields.add("userid");
        fields.add("forumname");
    }
    

    /**
     * ************************************************************************
     * printIntoFile
     *
     * @param fileName
     * @param content
     ************************************************************************
     */
    public void printIntoFile(String fileName, List<PostRating> ratingsItem) {
        FileWriter file = null;
        PrintWriter printWrite = null;
        try {
            file = new FileWriter(fileName);
            printWrite = new PrintWriter(file);
            
            initFileRFields();

            for (String field : fields) {
                printWrite.print(field + "\t");
            }
            
            for (PostRating rating : ratingsItem) {
                printWrite.print("\n");
                printWrite.print(rating.getCourseid() + "\t");
                printWrite.print(rating.getForumid() + "\t");
                printWrite.print(rating.getForumname() + "\t");
                printWrite.print(rating.getPostid() + "\t");
                printWrite.print(rating.getRating() + "\t");
                printWrite.print(rating.getRoleid() + "\t");
                printWrite.print(rating.getRolename() + "\t");
                printWrite.print(rating.getScaleid() + "\t");
                printWrite.print(rating.getUserid() + "\t");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != file) {
                    file.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
