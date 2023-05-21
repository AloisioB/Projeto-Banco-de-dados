package soccerchampionship;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends Employee {
    private String position;
    private int shirtNumber;

    @ManyToOne
    @JoinColumn(name = "team_name")
    private Team team;

    public Player() {
    }

    public Player(String name, String position, int shirtNumber) {
        super(name);
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

