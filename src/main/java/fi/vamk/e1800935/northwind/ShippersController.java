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
public class ShippersController {
	@Autowired
	private ShippersRepository repository;
	@RequestMapping(value = "/Shippers", method = RequestMethod.POST)
	public @ResponseBody Shippers create(@RequestBody final Shippers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Shippers", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Shippers> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Shippers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Shippers> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Shippers", method = RequestMethod.PUT)
	public @ResponseBody Shippers update(@RequestBody Shippers item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Shippers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Shippers item) {
		repository.delete(item);
	}

}