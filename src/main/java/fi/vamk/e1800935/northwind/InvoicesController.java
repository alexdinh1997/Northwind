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
public class InvoicesController {
	@Autowired
	private InvoicesRepository repository;
	@RequestMapping(value = "/Invoices", method = RequestMethod.POST)
	public @ResponseBody Invoices create(@RequestBody final Invoices item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Invoices", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Invoices> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Invoices/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Invoices> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Invoices", method = RequestMethod.PUT)
	public @ResponseBody Invoices update(@RequestBody Invoices item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Invoices", method = RequestMethod.DELETE)
	public void delete(@RequestBody Invoices item) {
		repository.delete(item);
	}

}