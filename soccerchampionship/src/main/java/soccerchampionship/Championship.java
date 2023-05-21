package soccerchampionship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "championships")
public class Championship {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "championship_team",
        joinColumns = @JoinColumn(name = "championship_id"),
        inverseJoinColumns = @JoinColumn(name = "team_name")
    )
    private List<Team> teams;

    public Championship() {
        this.teams = new ArrayList<>();
    }

    public Championship(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
        team.getChampionships().add(this);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

    
}
