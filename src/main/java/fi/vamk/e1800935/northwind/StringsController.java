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
public class StringsController {
	@Autowired
	private StringsRepository repository;
	@RequestMapping(value = "/Strings", method = RequestMethod.POST)
	public @ResponseBody Strings create(@RequestBody final Strings item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Strings", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Strings> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Strings/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Strings> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Strings", method = RequestMethod.PUT)
	public @ResponseBody Strings update(@RequestBody Strings item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Strings", method = RequestMethod.DELETE)
	public void delete(@RequestBody Strings item) {
		repository.delete(item);
	}

}