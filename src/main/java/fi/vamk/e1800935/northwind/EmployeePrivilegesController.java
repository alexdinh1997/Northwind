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
public class EmployeePrivilegesController {
	@Autowired
	private EmployeePrivilegesRepository repository;
	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.POST)
	public @ResponseBody EmployeePrivileges create(@RequestBody final EmployeePrivileges item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/EmployeePrivileges", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<EmployeePrivileges> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/EmployeePrivileges/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<EmployeePrivileges> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.PUT)
	public @ResponseBody EmployeePrivileges update(@RequestBody EmployeePrivileges item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.DELETE)
	public void delete(@RequestBody EmployeePrivileges item) {
		repository.delete(item);
	}

}