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
public class ProductsController {
	@Autowired
	private ProductsRepository repository;
	@RequestMapping(value = "/Products", method = RequestMethod.POST)
	public @ResponseBody Products create(@RequestBody final Products item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Products", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Products> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/Products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<Products> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/Products", method = RequestMethod.PUT)
	public @ResponseBody Products update(@RequestBody Products item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/Products", method = RequestMethod.DELETE)
	public void delete(@RequestBody Products item) {
		repository.delete(item);
	}

}