package codemasters.codematersspringcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codemasters.codematersspringcrud.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}