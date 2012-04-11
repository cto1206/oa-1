package cn.edu.zhku.oa.manager;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.manager.PersonManager;
import cn.edu.zhku.oa.model.Person;

public class PersonManagerTest extends TestCase {

	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	public void testAddPerson() {
		PersonManager personManager = (PersonManager)factory.getBean("personManager");
		
		Person person = new Person();
		person.setName("����");
		person.setAddress("����·500��");
		person.setDuty("ѧ������ϯ");
		
		//personManager.addPerson(person);
	}

	public void testDelPerson() {
		PersonManager personManager = (PersonManager)factory.getBean("personManager");
		personManager.delPerson(1);
	}

	public void testUpdatePerson() {
		PersonManager personManager = (PersonManager)factory.getBean("personManager");
		
		Person person = new Person();
		person.setId(2);
		person.setName("����");
		//personManager.updatePerson(person);
	}

	public void testFindPerson() {
		PersonManager personManager = (PersonManager)factory.getBean("personManager");
		//List personList = personManager.findPersons();
		//System.out.println("name="+person.getName());
	}

}
