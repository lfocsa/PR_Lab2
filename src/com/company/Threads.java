package com.company;

import java.util.ArrayList;

public class Threads extends Thread {

    private ArrayList<Threads> threadWaiting;
    private boolean finished = false;
    private String threadName;

    public Threads(String threadName) { this.threadName = threadName;
    }

    @Override
    public void run() {this.runThreads();
    }

    public ArrayList<Threads> getthreadWaiting() { return threadWaiting;
    }

    public void setThreadWaiting(ArrayList<Threads> threadWaiting) {
        this.threadWaiting = threadWaiting;
    }

    public boolean isFinished() { return finished;
    }

    public void setFinished(boolean finished) { this.finished = finished;
    }

    public String getThreadName() { return threadName;
    }

    public void setThreadName(String threadName) throws IllegalMonitorStateException {
        this.threadName = threadName;
    }

    public void runThreads() {

        if (threadWaiting != null) {
            for (Threads threads : threadWaiting) {
                if (!threads.isFinished()) {
                    synchronized (threads) {
                        try {
                            threads.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

        System.out.println(threadName);
        this.finished = true;
        synchronized (this) {
            this.notifyAll();
        }
    }

}
