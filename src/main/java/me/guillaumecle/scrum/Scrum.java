package me.guillaumecle.scrum;

import java.util.List;

import me.guillaumecle.Adjustments;
import me.guillaumecle.Agile;
import me.guillaumecle.Goal;
import me.guillaumecle.Priority;
import me.guillaumecle.Progress;
import me.guillaumecle.Reflection;
import me.guillaumecle.Release;
import me.guillaumecle.Requirement;
import me.guillaumecle.Team;
import me.guillaumecle.Work;

public class Scrum implements Agile {

    public Sprint createSprint(Goal goal, Work work){
        return new Sprint(goal, work);
    }

    @Override
    public void collaborate(Team team) {
        ScrumTeam scrumTeam = (ScrumTeam) team;

        DailyScrum scrum = new DailyScrum(scrumTeam);
        scrum.host();

        Sprint sprint = createSprint(new Goal("To deliver value!"), 
                            getWork(scrumTeam.getProductOwner().getRequirements()));
        sprint.plan();
        sprint.workOn();
    }

    @Override
    public Work getWork(List<Requirement> requirements) {
        requirements.sort(Priority.HIGH_PRIORITY_ORDER);
        return new Work(requirements);
    }

    @Override
    public Release deliver(Work work) {
        return work.deliver();
    }

    @Override
    public Progress getProgress(Work work) {
        return work.getCompletedWork();
    }

    @Override
    public Adjustments retrospective(Reflection reflection) {
        Adjustments adjustments = new Adjustments();
        adjustments.add(reflection.getWhatWorkedWell());
        adjustments.add(reflection.getWhatDidntWorkWell());
        adjustments.add(reflection.getFutureSprintCommitment());
        return adjustments;
    }
}
