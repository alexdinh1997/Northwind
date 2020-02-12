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
public class EmployeesController {
	@Autowired
	private EmployeesRepository repository;
	@RequestMapping(value = "/Employees", method = RequestMethod.POST)
	public @ResponseBody Employees create(@RequestBody final Employees item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Employees", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Employees> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Employees/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Employees> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Employees", method = RequestMethod.PUT)
	public @ResponseBody Employees update(@RequestBody Employees item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Employees", method = RequestMethod.DELETE)
	public void delete(@RequestBody Employees item) {
		repository.delete(item);
	}

}