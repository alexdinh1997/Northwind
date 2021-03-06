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
public class OrdersTaxStatusController {
	@Autowired
	private OrdersTaxStatusRepository repository;
	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.POST)
	public @ResponseBody OrdersTaxStatus create(@RequestBody final OrdersTaxStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrdersTaxStatus", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<OrdersTaxStatus> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/OrdersTaxStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<OrdersTaxStatus> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.PUT)
	public @ResponseBody OrdersTaxStatus update(@RequestBody OrdersTaxStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrdersTaxStatus item) {
		repository.delete(item);
	}

}