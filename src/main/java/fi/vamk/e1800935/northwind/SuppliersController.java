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
public class SuppliersController {
	@Autowired
	private SuppliersRepository repository;
	@RequestMapping(value = "/Suppliers", method = RequestMethod.POST)
	public @ResponseBody Suppliers create(@RequestBody final Suppliers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Suppliers", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Suppliers> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Suppliers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Suppliers> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Suppliers", method = RequestMethod.PUT)
	public @ResponseBody Suppliers update(@RequestBody Suppliers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Suppliers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Suppliers item) {
		repository.delete(item);
	}

}