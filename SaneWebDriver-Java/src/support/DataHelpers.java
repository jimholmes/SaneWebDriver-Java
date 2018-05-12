package support;

import com.github.javafaker.Faker;

/* This is an example of a class that helps with test generation and API calls.
 * 
 * Please note the actual calls to web services and database are FAKED OUT.
 * Implementation of these calls requires a lot of additional goo that would
 * complicate these examples due to lots of dependencies.
 * 
 * For a working, practical example of API support please see my "Demo-Site"
 * project on GitHub, specifically: 
 * https://github.com/jimholmes/Demo-Site/blob/master/SupportApi/DataHelpers.cs
 * 
 * That file in turn uses the Models of the enclosing Demo-Site project.
 * 
 */

public class DataHelpers {
	public static int MADE_UP_ID = 255;

	public static ContactDataObject Generate_random_contact() {
		ContactDataObject contact = new ContactDataObject();
		Faker faker = new Faker();
		contact.setCompany(faker.company().bs());
		contact.setFname(faker.name().firstName());
		contact.setLname(faker.name().lastName());
		contact.setRegion(faker.address().country());
		contact.setId(MADE_UP_ID);

		return contact;
	}

	/*
	 * This method is a stub. It STORES NOTHING IN A DATABASE! It simply returns a
	 * Contact object with a fake ID.
	 * 
	 * This is just meant to show you how a helper/support library might work.
	 * 
	 * Did I mention this doesn't save to a database???
	 */
	public static ContactDataObject create_and_store_random_contact_in_db() {
		return Generate_random_contact();
	}

	/*
	 * This method is a stub. It RETRIVES NOTHING FROM A DATABASE! It's meant to
	 * simulate querying the DB by ID and returning that contact.
	 * 
	 * This is just meant to show you how a helper/support library might work.
	 * 
	 * Did I mention this doesn't get anything from a database???
	 */
	public static ContactDataObject return_contact_by_id(ContactDataObject contact) {
		return contact;
	}

	/*
	 * This method is a stub. It DELETES NOTHING FROM A DATABASE! It simply returns
	 * true to simulate having deleted actual data.
	 * 
	 * This is just meant to show you how a helper/support library might work.
	 * 
	 * Did I mention this doesn't delete anything from a database???
	 */
	public static Boolean delete_contact_by_id(ContactDataObject contact) {
		return true;
	}
}
