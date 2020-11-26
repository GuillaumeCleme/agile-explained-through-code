package me.guillaumecle.scrum.yourimplementation;

import me.guillaumecle.Goal;
import me.guillaumecle.Team;
import me.guillaumecle.scrum.DailyScrum;
import me.guillaumecle.scrum.Scrum;
import me.guillaumecle.scrum.ScrumTeam;
import me.guillaumecle.scrum.Sprint;

public class YourScrum extends Scrum {

    @Override
    public void collaborate(Team team) {
        ScrumTeam scrumTeam = (ScrumTeam) team;

        DailyScrum scrum = new DailyScrum(scrumTeam);
        scrum.host();

        //Make it your own!
        YourOwnProcess yourOwnProcess = new YourOwnProcess();
        yourOwnProcess.implement();

        Sprint sprint = super.createSprint(new Goal("To deliver value!"), 
                                getWork(scrumTeam.getProductOwner().getRequirements()));
        sprint.plan();
        sprint.workOn();
    }
}
