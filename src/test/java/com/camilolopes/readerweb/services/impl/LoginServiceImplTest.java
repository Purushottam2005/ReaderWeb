package com.camilolopes.readerweb.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dbunit.config.DBUnitConfiguration;
import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.model.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/OrderPersistenceTests-context.xml"})
@TransactionConfiguration
@Transactional
public class LoginServiceImplTest extends DBUnitConfiguration{

	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}
	
	private User getUserById(long id){
		User user = (User) getSessionFactory().getCurrentSession().get(User.class, id);
		return user;
	}

	@Test
	public void testAuthenticateSucessfulWithUserValid() {
		User userCamilo = getUserById(1);
		try{
			loginServiceImpl.authenticate(userCamilo.getEmail(),userCamilo.getPassword());
		}catch (Exception e) {
			fail("Not expected result");
		}
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserEmailNullIsInvalid() throws EmailException{
		loginServiceImpl.authenticate(null,"12");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserNotExist() throws EmailException{
		loginServiceImpl.authenticate("xnbml","0000");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserEmailIsValidButPasswordInvalid() throws EmailException{
		User user = getUserById(1);
		loginServiceImpl.authenticate(user.getEmail(), "12345");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserEmailInvalid() throws EmailException{
		loginServiceImpl.authenticate("invalid@invalid.com", "x12x");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserEmailValidButPasswordcannotbeNull() throws EmailException{
		String email = getUserById(1).getEmail();
		loginServiceImpl.authenticate(email, null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserValidButStatusInactive() throws EmailException{
		loginServiceImpl.authenticate("ivete@sangalo.com", "123");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserValidActiveButExpiredDate() throws EmailException{
		loginServiceImpl.authenticate("joao@email.com", "123");
	}

}
