package soccerchampionship;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "headquarters")
    private String headquarters;

    @OneToMany(mappedBy = "team")
    private List<Employee> employees;

    @ManyToMany(mappedBy = "teams")
    private List<Championship> championships;

    public Team() {
        this.employees = new ArrayList<>();
        this.championships = new ArrayList<>();
    }

    public Team(String name, String headquarters) {
        this.name = name;
        this.headquarters = headquarters;
        this.employees = new ArrayList<>();
        this.championships = new ArrayList<>();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Championship> getChampionships() {
		return championships;
	}

	public void setChampionships(List<Championship> championships) {
		this.championships = championships;
	}

    
}
