
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.red5.core.Application;
import org.red5.core.GcmUsers;

public class ApplicationTester {

	Application butterflyApp;
	@Before
	public void before() {
		butterflyApp = new Application();
	}

	@After
	public void after() {
		butterflyApp = null;
	}

	@Test
	public void testRegisterStream() {
		boolean registerLiveStream = butterflyApp.registerLiveStream("publishedName", "publishUrl", null, null, true, null);
		assertEquals(registerLiveStream, true);

		registerLiveStream = butterflyApp.registerLiveStream("publishedName", "publishUrl", null, null, true, null);
		assertEquals(registerLiveStream, false);


		registerLiveStream = butterflyApp.registerLiveStream("publishedName"+11, "publishUrl", null, null, true, null);
		//should return false because url is key
		assertEquals(registerLiveStream, false);

		registerLiveStream = butterflyApp.registerLiveStream("publishedName", "publishUrl" + 11, null, null, true, null);
		//should return true because url is changed
		assertEquals(registerLiveStream, true);
	}

	@Test
	public void testRemoveStream() {
		boolean registerLiveStream = butterflyApp.registerLiveStream("publishedName", "publishUrl", null, null, true, null);
		assertEquals(registerLiveStream, true);

		registerLiveStream = butterflyApp.removeStream("publishUrl");
		assertEquals(registerLiveStream, true);

		registerLiveStream = butterflyApp.removeStream("publishUrl" + 1234);
		assertEquals(registerLiveStream, false);
	}

	@Test
	public void testRegisterUser() {
		int t = (int) (Math.random()*1000);
		boolean result = butterflyApp.registerUser(String.valueOf(t), "dgsdgs");
		assertEquals(true, result);
	}

	@Test
	public void testUserUpdate()
	{
		int count = butterflyApp.getUserCount("mail1");
		int initialCount = count;
		
		int t = (int) (Math.random()*1000);
		boolean result = butterflyApp.registerUser(String.valueOf(t), "mail1");
		assertEquals(true, result);
		
		GcmUsers registerId = butterflyApp.getRegistrationIdList("mail1");
		assertEquals(registerId.fetchRegIDStrings().get(0), String.valueOf(t));
		
		count = butterflyApp.getUserCount("mail1");
		assertEquals(initialCount+1, count);
		
		t = (int) (Math.random()*1000);
		result = butterflyApp.registerUser(String.valueOf(t), "mail1");
		assertEquals(true, result);
		
		registerId = butterflyApp.getRegistrationIdList("mail1");
		assertEquals(registerId.fetchRegIDStrings().get(0), String.valueOf(t));
		
		count = butterflyApp.getUserCount("mail1");
		assertEquals(initialCount+1, count);

	}
	

	@Test
	public void testGetRegistrationId() {
		int t = (int) (Math.random()*1000);
		String mail = "mail@mailc.com" + t;
		boolean result = butterflyApp.registerUser(String.valueOf(t), mail);
		assertEquals(result, true);

		GcmUsers registerId = butterflyApp.getRegistrationIdList(mail);

		assertEquals(registerId.fetchRegIDStrings().get(0), String.valueOf(t));

		registerId = butterflyApp.getRegistrationIdList("slkdjflasjf" + t);

		assertEquals(registerId, null);
	}
	
	@Test
	public void testDeleteUser()
	{
		int t = (int) (Math.random()*1000);
		String mail = "murat@mailc.com" + t;
		boolean result = butterflyApp.registerUser(String.valueOf(t), mail);
		assertEquals(result, true);

		GcmUsers registerId = butterflyApp.getRegistrationIdList(mail);

		assertEquals(registerId.fetchRegIDStrings().get(0), String.valueOf(t));

		butterflyApp.deleteUser(registerId);
		
		registerId = butterflyApp.getRegistrationIdList(mail);

		assertEquals(registerId, null);
	}
	
//	@Test
//	public void testSendMail() {
//		ArrayList<String> mail = new ArrayList<String>();
//		mail.add("ahmetmermerkaya@gmail.com");
//		butterflyApp.sendMail(mail, "Test mail ", "Bu bir test mailidir.");
//		
//		String mailString = new String();
//		for (int i = 0; i < mail.size(); i++) {
//			mailString += mail.get(i) + ",";
//		}
//		fail("to correct this test check mail is received at " + mailString);
//	}
	
//	@Test
//	public void testSendNotificationOrMail()
//	{
//		butterflyApp.sendNotificationsOrMail("ahmetmermerkaya@gmail.com","mail;videourl","en");
//	}



	






}

