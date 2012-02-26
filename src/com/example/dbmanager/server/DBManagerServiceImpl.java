package com.example.dbmanager.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.example.dbmanager.domain.Person;
import com.example.dbmanager.util.HibernateUtil;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DBManagerServiceImpl extends RemoteServiceServlet implements
									DBManagerService {

  	public List<Person> getPeople() {
  		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  		List<Person> people = session.createQuery("from Person").list();
  		session.getTransaction().commit();
	  	return people;
  	}
  	
  	public PagingLoadResult<Person> getBeanPeople(PagingLoadConfig config) {
  		List<Person> people = getPeople();
  		//List<Person> result = new ArrayList<Person>();
  		int start = config.getOffset();
  		int limit = people.size();
  		if (config.getLimit() > 0) {  
  			limit = Math.min(start + config.getLimit(), limit);  
  		}
  		    
  		ArrayList<Person> result = new ArrayList<Person>();
  		for (int i = config.getOffset(); i < limit; i++) {
  			result.add(people.get(i));       
  		}    
  	
  		return new BasePagingLoadResult<Person>(result, config.getOffset(), people.size());	
  	}

	public Long savePerson(Person aPerson) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();
	    session.save(aPerson);
	    session.getTransaction().commit();
	    return aPerson.getId();
	}

	public void updatePerson(Person aPerson) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(aPerson);
		session.getTransaction().commit();
	}

	public Integer removePerson(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Person where id = " + id);
		return new Integer(query.executeUpdate());
	}
}
