package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Threads threads1 = new Threads("Node1");
        Threads threads2 = new Threads("Node2");
        Threads threads3 = new Threads("Node3");
        Threads threads4 = new Threads("Node4");
        Threads threads5 = new Threads("Node5");
        Threads threads6 = new Threads("Node6");
        Threads threads7 = new Threads("Node7");


        threads1.setThreadWaiting(new ArrayList<>(Arrays.asList(threads2,threads3)));
        threads2.setThreadWaiting(new ArrayList<>(Arrays.asList(threads5,threads6)));
        threads3.setThreadWaiting(new ArrayList<>(Arrays.asList(threads4,threads7)));

        threads1.start();
        threads2.start();
        threads3.start();
        threads4.start();
        threads5.start();
        threads6.start();
        threads7.start();

        try {

            threads1.join();
            threads2.join();
            threads3.join();
            threads4.join();
            threads5.join();
            threads6.join();
            threads7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    };

}
