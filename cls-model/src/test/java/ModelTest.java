import static org.junit.Assert.*;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metamodel.source.annotations.xml.mocker.MockHelper;
import org.junit.Test;

import com.dim.cls.model.HibernateUtil;
import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;

import static org.mockito.Mockito.*;

public class ModelTest {
	
	@Test
	public void test() {
		
		/*
		org.hibernate.SessionFactory sessionFactory = mock(SessionFactory.class);
		org.hibernate.Session session = mock(Session.class);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		*/
		
		//opeaning a session from sessionFactory(one per application) object
		Session session = HibernateUtil.getSessionFactory().openSession(); //session has a connection internally. Session knows how to do ORM mappins
		Session session2 = HibernateUtil.getSessionFactory().openSession(); //session has a connection internally. Session knows how to do ORM mappins
		Session session3 = HibernateUtil.getSessionFactory().openSession(); //session has a connection internally. Session knows how to do ORM mappins

		//AbstractPerson p = new AbstractPerson() ;
		
		//p.setFirstName("Dimuthu");
		//session.beginTransaction();
		//session.save(p);
		
		//writing to the table

		//session.getTransaction().commit();

		//session.close(); // normally in the final block. this class the associated persistancy context.
//		
//		//reading object from db
//		AbstractPerson p1 = new AbstractPerson();
//		session.beginTransaction();
//		//p1 = (AbstractPerson)session2.get(AbstractPerson.class, Long.parseLong("1"));
//		//p1.setFirstName("updated Dimuthu 5");
//		//System.out.println(p1.getFirstName());
//		Query q1 = session.createQuery("from AbstractPerson");
//		q1.setCacheable(true);
//		Query q2 = session.createQuery("from AbstractPerson");
//		q2.setCacheable(true);
//		
//		q1.list();
//		
//		q1.list();
//		
//		
//		//AbstractPerson p2 = new AbstractPerson();
//		//p2 = (AbstractPerson)session2.get(AbstractPerson.class, Long.parseLong("1"));
//		//p2.setFirstName("updated Dimuthu 6");
//		//System.out.println(p2.getFirstName());
//		
//		//AbstractPerson p3 = new AbstractPerson();
//		//p3 = (AbstractPerson)session3.get(AbstractPerson.class, Long.parseLong("1"));
//		//System.out.println(p3.getFirstName());
//		
//		
//		session2.close();
//		session3.close();
//		
//		
//		/*
//		//read from table
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		AbstractPerson p2 = (AbstractPerson)session.get(AbstractPerson.class, 1); //pull up the record with userId as 1.
//		System.out.println("user name retried is : " + p2.getFirstName());
//		session.close();
//		
//		
//		//read collection
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		AbstractPerson p3 = (AbstractPerson)session.get(AbstractPerson.class, 1); //pull up the record with userId as 1.
//		//p3.getAddress();
//		System.out.println("user name retried is : " + p2.getFirstName());
//		session.close();
//		
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		//creating the object
//		//AbstractPerson p4 = new StaffMember(); 
//		//p4.setFirstName("Dimuthu");
//		//saving the object to database
//		//session.save(p4);
//		
//		session.close();	
//		
//		
//		
//		session = HibernateUtil.getSessionFactory().openSession();
//		
//		Criteria criteria = session.createCriteria(AbstractPerson.class);
//		
//		criteria.setProjection(Projections.max("userName"));
//		
//		criteria.add(Restrictions.eq("userName", "Dimuthu")).
//		add(Restrictions.between("age", 10, 15)).
//		add(Restrictions.or(Restrictions.le("userId", 5),Restrictions.gt("salary", 100) ))
//		
//		
//		;
//		
//		
//		criteria.addOrder(Order.asc("userId"));
//		
//		
//		AbstractPerson pe3 = new AbstractPerson();
//		//pe3.setDob(new Date());
//		pe3.setIdInternal(Long.parseLong("12312"));
//		pe3.setFirstName("Dim%");
//		
//		Example example = Example.create(pe3).enableLike();
//		
//	   session = HibernateUtil.getSessionFactory().openSession();
//		
//		criteria = session.createCriteria(AbstractPerson.class);
//		criteria.add(example);
//		
//		
		
		
	}

}
