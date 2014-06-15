/**
 * 
 */
package com.sivalabs.myapp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Siva
 *
 */
@Stateless
public class UserServiceBean
{

	@PersistenceContext
	private EntityManager em;
	
	public User login(String email, String password)
	{
		String sql = "select u from User u where u.email=:email and u.password=:password ";
		TypedQuery<User> query = em.createQuery(sql, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> list = query.getResultList();
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

	public User create(User user)
	{
		em.persist(user);
		return user;
	}
	
}
