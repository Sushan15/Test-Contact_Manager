package contactManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ContactManagerImplimentation implements ContactManager{
	Map<Long,Contact> map=new HashMap<>();
	
	public boolean addContact(Contact c) {
		String cnumber=""+c.contactNumber;
		if (c.firstName == null || c.lastName==null||cnumber.length()!=10) {
	        return false;
	    }
		
	    map.put(c.contactNumber, c); 
	    return true;
	}
	
	public boolean deleteContact(Contact c) {
	    if (!map.containsKey(c.contactNumber)) {
	        return false;
	    }
	    map.remove(c.contactNumber);
	    return true;
	}

	public boolean updateContact(Contact c) {
	    if (map.containsKey(c.contactNumber)) {
	        map.put(c.contactNumber, c);
	        return true;
	    }
	    return false;
	}

	public Contact viewContact(Contact c) {
	    return map.get(c.contactNumber);
	}

}
