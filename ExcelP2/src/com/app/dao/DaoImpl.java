package com.app.dao;
import static com.app.utils.HibUtils.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.User;

public class DaoImpl {
	
	/*
	 * @Autowired private static SessionFactory sf;
	 */
	
	public static void saveToDB(Map<String,User> map)
	{
		Session hibSess = getSf().openSession();
		// begin tx
		Transaction tx = hibSess.beginTransaction();
		try {
			User u = new User();
		List<User> listOfValues = map.values().stream().collect(Collectors.toList());
		
		for(User user:listOfValues)
		{
			hibSess.save(user);
		}
		
		tx.commit();
	}catch (Exception e) {
		if (tx != null)
			tx.rollback();
		// throw e;
	} finally {
		if (hibSess != null)
			hibSess.close();// cn rets to dn cn pool,l1 cache cleared
	}
	// c
	
}
	

}
