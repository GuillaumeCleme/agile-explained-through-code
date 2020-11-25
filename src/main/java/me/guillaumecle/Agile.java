package me.guillaumecle;

import java.util.List;

interface Agile {
    
    public void collaborate(Team team);

    public Work getWork(List<Requirement> requirements);
    
    public Release deliver(Work work);

    public Progress getProgress(Work work);

    public Adjustments retrospective(Reflection reflection);
}