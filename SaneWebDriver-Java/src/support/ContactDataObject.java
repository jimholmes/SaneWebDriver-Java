package support;

/*
 * Data model for the contact grid.
 * See also https://github.com/jimholmes/Demo-Site/blob/master/WebApi/Models/Contact.cs
 * 
 * Note: Normally I would never name something "<x>DataObject" as it just adds noise.
 *    ...But for this example project it makes readability a bit clearer.
 */
public class ContactDataObject {

	private int id;
	private String region;
	private String company;
	private String lname;
	private String fname;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}
