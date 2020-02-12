package fi.vamk.e1800935.northwind;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
public class CustomersController {
	@Autowired
	private CustomersRepository repository;
	@RequestMapping(value = "/Customers", method = RequestMethod.POST)
	public @ResponseBody Customers create(@RequestBody final Customers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Customers", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Customers> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Customers> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Customers", method = RequestMethod.PUT)
	public @ResponseBody Customers update(@RequestBody Customers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Customers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Customers item) {
		repository.delete(item);
	}

}