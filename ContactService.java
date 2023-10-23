import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contactMap = new HashMap<>();

    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactID())) {
            //  duplicate contact ID error
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contactMap.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contactMap.containsKey(contactID)) {
            // contact not found error
            throw new IllegalArgumentException("Contact not found.");
        }
        contactMap.remove(contactID);
    }

    public void updateContact(String contactID, String field, String value) {
        Contact contact = contactMap.get(contactID);
        if (contact == null) {
            // contact not found error
            throw new IllegalArgumentException("Contact not found.");
        }

        switch (field) {
            case "firstName":
                contact.setFirstName(value);
                break;
            case "lastName":
                contact.setLastName(value);
                break;
            case "phone":
                if (value.length() != 10) {
                    //invalid phone number length error
                    throw new IllegalArgumentException("Invalid phone number length.");
                }
                contact.setPhone(value);
                break;
            case "address":
                if (value.length() > 30) {
                    // Handle address too long error
                    throw new IllegalArgumentException("Address is too long.");
                }
                contact.setAddress(value);
                break;
            default:
                // invalid field name
                throw new IllegalArgumentException("Invalid field name.");
        }

    }
    public Contact getContactByID(String contactID) {
        return contactMap.get(contactID);
    }
}