/*
Author: Liam O'Shea
File: Process.java
Date: November 25 2018
Description: This class describes a Process object. The class keeps track of Process ID, time required,
priority level, and the process' time of arrival.

toString and compareTo have been overridden. Process is comparable by priority.
 */

public class Process implements Comparable<Process> {
    private int id;
    private int timeReqd;
    private int priority;
    private int timeArrival;

    public Process(int id, int timeReqd, int priority, int timeArrival){
        this.id = id;
        this.timeReqd = timeReqd;
        this.priority = priority;
        this.timeArrival = timeArrival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeReqd() {
        return timeReqd;
    }

    public void setTimeReqd(int timeReqd) {
        this.timeReqd = timeReqd;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(int timeArrival) {
        this.timeArrival = timeArrival;
    }

    public String toString(){
        return "(" + id + "," + timeReqd + "," + priority + ")";
    }

    @Override
    public int compareTo(Process p) {
        if(p.priority < priority){
            return 1;
        } else if(p.priority > priority){
            return -1;
        } else{
            return 0;
        }
    }
}
