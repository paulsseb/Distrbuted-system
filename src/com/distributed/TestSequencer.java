package com.distributed;
 import java.io.*;
 import java.util.*;

public class TestSequencer {
    public static void main(String args[]) {
        Group newgrp=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your name");
        String name = sc.nextLine();
        TestSequencer objj = new TestSequencer();
        TestSequencer.MsgHandlers handles= objj.new MsgHandlers();

        try {
            newgrp = new Group("localhost",handles, name);

        } catch (Group.GroupException ex) {
            ex.printStackTrace();
        }
        while (true)
        {
            System.out.println("please enter your option ");
            System.out.println("1.Multicast messsage");
            System.out.println("2.Stress Test");
            System.out.println("3.History");
            System.out.println("4.Leave multicast group");
            String option = sc.nextLine();


            switch (option)
            {
                case "1":
                System.out.println("please input data to multicast");
                String message = sc.nextLine();
                byte[] msgsnd = message.getBytes();
                try {
                    newgrp.send(msgsnd);
                    Thread thread = new Thread(newgrp);
                    thread.start();

                } catch (Group.GroupException ex) {
                    ex.printStackTrace();
                }
                break;

                case "2" :
                System.out.println("******Stress testing has been chosen******");

                break;
                case "3" :
                    System.out.println("************history***********");
                    newgrp.viewhistory();
                    System.out.println(""

                    );

                    break;
                case "4" :
                    System.out.println("you have chosen to leave");
                    newgrp.leave();
                    break;

                default : //Optional
                     System.out.println("Invalid option chosen...");
            }
        }
    }
    public class MsgHandlers implements Group.MsgHandler{
        MsgHandlers(){
        }
        @Override
        public void handle(int count, byte[] msg) {
            String messagein = new String(msg, 0,count);
            System.out.println("This messagge was sent: " + messagein);
        }
    }

}
