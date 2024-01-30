package codemasters.codematersspringcrud.service;

import codemasters.codematersspringcrud.entity.Contact;
import codemasters.codematersspringcrud.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    public Contact saveContact(Contact contact) {
        contact.setCreatedAt(Instant.now());
        return contactRepository.save(contact);
    }

    public Contact updateContact(Integer id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setMobileNumber(updatedContact.getMobileNumber());
        existingContact.setAddress(updatedContact.getAddress());
        existingContact.setFacebookUrl(updatedContact.getFacebookUrl());
        existingContact.setInstagramUrl(updatedContact.getInstagramUrl());
        existingContact.setTiktokUrl(updatedContact.getTiktokUrl());

        existingContact.setUpdatedAt(Instant.now());
        return contactRepository.save(existingContact);
    }

    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
