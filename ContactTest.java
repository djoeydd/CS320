import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactValidation() {
        // Create a valid contact
        Contact validContact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Test getters
        assertEquals("1", validContact.getContactID());
        assertEquals("John", validContact.getFirstName());
        assertEquals("Doe", validContact.getLastName());
        assertEquals("1234567890", validContact.getPhone());
        assertEquals("123 Main St", validContact.getAddress());

        // Test setters
        validContact.setFirstName("Jane");
        assertEquals("Jane", validContact.getFirstName());
    }

    @Test
    public void testInvalidContactCreation() {
        // Test creating a contact with an invalid phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("2", "Invalid", "Contact", "123", "Invalid Address");
        });

        // Test creating a contact with a null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("3", null, "Valid", "1234567890", "Valid Address");
        });
    }

}