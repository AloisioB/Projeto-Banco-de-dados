package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import soccerchampionship.Championship;

public class GetChampionshipName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("soccerchampionship");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    Championship c1 = em.find(Championship.class, 5L);
	    System.out.println(c1.getName());
	    c1.setName("Brasileirão");
	    em.merge(c1);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	    
	    
	}
	
}
