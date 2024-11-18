package testContactManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactManagementSystem.Contact;
import contactManagementSystem.ContactManager;
import contactManagementSystem.ContactManagerImplimentation;

class TestContactManager {

    ContactManager cm;

    @BeforeEach
    void setUp() {
        cm = new ContactManagerImplimentation();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("Sushan", "Shetty", 9999222233l);
        assertTrue(cm.addContact(contact));
    }

    @Test
    void testAddContactInvalidFirstName() {
        Contact contact = new Contact(null, "Shetty", 9999222233l);
        assertFalse(cm.addContact(contact));
    }

    @Test
    void testAddContactInvalidLastName() {
        Contact contact = new Contact("Sushan", null, 9999222233l);
        assertFalse(cm.addContact(contact));
    }

    @Test
    void testAddContactInvalidNumber() {
        Contact contact = new Contact("Sushan", "Shetty", 99992222l); 
        assertFalse(cm.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("Sushan", "Shetty", 9999222233l);
        cm.addContact(contact);
        assertTrue(cm.deleteContact(contact));
    }

    @Test
    void testDeleteNonExistentContact() {
        Contact contact = new Contact("SushanR", null, 9999222233l);
        assertFalse(cm.deleteContact(contact));
    }

    @Test
    void testUpdateContact() {
        Contact oldContact = new Contact("Venu", "Gopala", 9999222233l);
        cm.addContact(oldContact);

        Contact updatedContact = new Contact("Mr", "Gopala", 9999222233l);
        assertTrue(cm.updateContact(updatedContact));
    }

    @Test
    void testUpdateNonExistentContact() {
        Contact contact = new Contact("Mr", "Unknown", 9999999999L);
        assertFalse(cm.updateContact(contact));
    }

    @Test
    void testViewContact() {
        Contact contact = new Contact("Super", "Man", 6667778899L);
        cm.addContact(contact);

        Contact viewedContact = cm.viewContact(contact);
        assertEquals(contact.firstName, viewedContact.firstName);
        assertEquals(contact.lastName, viewedContact.lastName);
        assertEquals(contact.contactNumber, viewedContact.contactNumber);
    }

    @Test
    void testViewNonExistentContact() {
        Contact contact = new Contact("Super", "Man", 6667778899L);
        assertNull(cm.viewContact(contact));
    }
}
