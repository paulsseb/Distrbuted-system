package com.distributed;

import java.util.*;
public class History {
   public static ArrayList<String> historylog; //Arraylist  for storing message hitory

    History(){
        historylog = new ArrayList<>();
    }

    public void storeHistory(String msg){
        historylog.add(msg);

        if (historylog.size() > 1024)// history truncation.
        {
            historylog.clear();
        }
    }
    public void viewHistory(){
        Iterator itr = historylog.iterator();
        System. out. println("messages sent are ");
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.println(element + " ");
        }
    }
}
