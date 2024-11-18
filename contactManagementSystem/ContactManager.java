package contactManagementSystem;

public interface ContactManager {
	public boolean addContact(Contact c);
	public boolean deleteContact(Contact c);
	public boolean updateContact(Contact c);
	public Contact viewContact(Contact c);	
}
