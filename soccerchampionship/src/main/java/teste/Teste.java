package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import soccerchampionship.Championship;
import soccerchampionship.Employee;
import soccerchampionship.Player;
import soccerchampionship.Team;


public class Teste {
    public static void main(String[] args) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soccerchampionship");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee1 = new Employee("Sampaoli");
        Employee employee2 = new Employee("Ancelotti");

        Player player1 = new Player("Arrascaeta", "Midfielder", 10);
        Player player2 = new Player("Vinicius Jr", "Left Winger", 20);

        Team team1 = new Team("Flamengo", "Rio de Janeiro");
        Team team2 = new Team("Real Madrid", "Madrid");

        employee1.setTeam(team1);  // Sampaoli -> Flamengo
        employee2.setTeam(team2); // Ancelotti -> Real Madrid
        player1.setTeam(team1); // Arrascaeta -> Flamengo
        player2.setTeam(team2); // Vinicius Jr -> Real Madrid

        team1.getEmployees().add(employee1); 
        team1.getEmployees().add(player1);
        team2.getEmployees().add(employee2);
        team2.getEmployees().add(player2);

        
        Championship championship = new Championship("Champions League");
        championship.getTeams().add(team1);
        championship.getTeams().add(team2);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.persist(team1);
        entityManager.persist(team2);
        entityManager.persist(championship);
        transaction.commit();

        entityManager.close();

        entityManagerFactory.close();
    }
}
