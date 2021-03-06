/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author namng
 */
class RMJob{
    public Job j;
    public int piority;
}

class AvailableTimeslot{
    public double begin;
    public double end;

    public AvailableTimeslot(double begin, double end) {
        this.begin = begin;
        this.end = end;
    }
}
class FComparator implements Comparator<PeriodicTask> {
	public int compare(PeriodicTask s1, PeriodicTask s2) {
		if(s1.p == s2.p)
                    return 0;
                else if (s1.p > s2.p)
                    return 1;
                else
                    return -1;
	}
}

public class RMScheduler implements Scheduler{
    
    private ArrayList<PeriodicTask> tasks;
    private Schedule schedule;

    @Override
    public List<Task> getTasks() {
        return (List)tasks;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        if(tasks != null){
            if(tasks instanceof ArrayList){
                this.tasks = (ArrayList) tasks;
            }else{
                this.tasks = new ArrayList<>();
                for(int i = 0; i < tasks.size(); i++){
                    this.tasks.add((PeriodicTask)tasks.get(i));
                }
            }
        }
        schedule = null;
        assignments = new ArrayList<>();
    }

    @Override
    public PeriodicTask getTask(int taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTask(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTask(int taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startSchedule() {
        extend = -1;
        if(tasks != null && tasks.size() > 0){
            double hyperPeriod = calHyperPeriod();
            Collections.sort(tasks, new FComparator());
            List<AvailableTimeslot> atss = new LinkedList<>();
            double frameSize = hyperPeriod + calSchedulePhase();
            assignments = new ArrayList<>();
            atss.add(new AvailableTimeslot(0,frameSize));
            for(int i = 0; i < tasks.size(); i++){
                atss = scheduleTask(tasks.get(i), hyperPeriod, atss);
            }
            this.schedule = new Schedule(assignments);
        }
    }
    
    private double calSchedulePhase(){
        double phase = 0;
        if(tasks != null && tasks.size() > 0){
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getPhase() > phase){
                    phase = tasks.get(i).getPhase();
                }
            }
        }
        return phase;
    }
    
    private ArrayList<Assignment> assignments;
    
    private List<AvailableTimeslot> scheduleJob(Job j, List<AvailableTimeslot> atss){
        if(atss != null && atss.size() > 0){
            double remain = j.getTask().getExeTime();
            for(int i = 0; i < atss.size(); i++){
                double begin = atss.get(i).begin;
                if(begin < j.getReleaseTime()){
                    if(atss.get(i).end < j.getReleaseTime()){
                        continue;
                    }
                    AvailableTimeslot ts1 = new AvailableTimeslot(begin, j.getReleaseTime());
                    AvailableTimeslot ts2 = new AvailableTimeslot(begin, atss.get(i).end);
                    begin = j.getReleaseTime();
                    atss.remove(i);
                    atss.add(i,ts2);
                    atss.add(i,ts1);
                    i++;
                }
                double end = begin + remain;
                if(end >= atss.get(i).end){
                    end = atss.get(i).end;
                    atss.remove(i);
                    i--;
                }
                else{
                    AvailableTimeslot ts1 = new AvailableTimeslot(end, atss.get(i).end);
                    atss.remove(i);
                    atss.add(i, ts1);
                    i--;
                }
                remain = remain - (end - begin);
                Assignment a = new Assignment();
                a.beginTime = begin;
                a.endTime = end;
                a.job = j;
                if(assignments == null){
                    assignments = new ArrayList<>();
                }
                assignments.add(a);
                if(remain == 0){
                    break;
                }
            }
        }
        else{
            if(extend == -1){
                extend = calHyperPeriod() + calSchedulePhase();
            }
            Assignment a = new Assignment();
            a.beginTime = extend;
            a.endTime = extend + j.getTask().getExeTime();
            a.job = j;
            extend = a.endTime;
            assignments.add(a);
        }
        return atss;
    }
    
    private double extend=-1;
    
    private List<AvailableTimeslot> scheduleTask(PeriodicTask task, double hyperPeriod, List<AvailableTimeslot> atss){
        int k = (int)(hyperPeriod/task.getPeriod());
        for(int i = 0; i < k; i++){
            Job j = new Job(task, i, task.getPeriod() * i + task.getPhase());
            atss = scheduleJob(j, atss);
        }
        return atss;
    }

    @Override
    public Schedule getSchedule() {
        return this.schedule;
    }
    
    private double calHyperPeriod(){
        double h = -1;
        if(tasks != null && tasks.size() > 0){
            h = tasks.get(0).p;
            for(int i = 1; i < tasks.size(); i++){
                h = lcm(h, tasks.get(i).p);
            }
        }
        return h;
    }
    
    public static double lcm(double number1, double number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        double absNumber1 = Math.abs(number1);
        double absNumber2 = Math.abs(number2);
        double absHigherNumber = Math.max(absNumber1, absNumber2);
        double absLowerNumber = Math.min(absNumber1, absNumber2);
        double lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
    
}
