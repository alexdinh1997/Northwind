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
public class OrderDetailsController {
	@Autowired
	private OrderDetailsRepository repository;
	@RequestMapping(value = "/OrderDetails", method = RequestMethod.POST)
	public @ResponseBody OrderDetails create(@RequestBody final OrderDetails item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrderDetails", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<OrderDetails> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/OrderDetails/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<OrderDetails> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/OrderDetails", method = RequestMethod.PUT)
	public @ResponseBody OrderDetails update(@RequestBody OrderDetails item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrderDetails", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrderDetails item) {
		repository.delete(item);
	}

}