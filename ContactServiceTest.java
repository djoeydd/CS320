import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact validContact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Test adding a valid contact
        contactService.addContact(validContact);
        assertEquals(validContact, contactService.getContactByID("1"));

        // Test adding a contact with a duplicate ID
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(validContact);
        });

        // Add more tests as needed
    }

    @Test
    public void testDeleteContact() {
        // Create a ContactService instance and add contacts
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // Test deleting an existing contact
        contactService.deleteContact("1");
        assertNull(contactService.getContactByID("1"));

        // Test deleting a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("3");
        });

    }

    @Test
    public void testUpdateContact() {
        // Create a ContactService instance and add a contact for testing
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test updating the first name
        contactService.updateContact("1", "firstName", "Jane");
        assertEquals("Jane", contactService.getContactByID("1").getFirstName());

        // Test updating the phone number
        contactService.updateContact("1", "phone", "9876543210");
        assertEquals("9876543210", contactService.getContactByID("1").getPhone());
    }
}