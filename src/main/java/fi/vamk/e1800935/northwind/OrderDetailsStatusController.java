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
public class OrderDetailsStatusController {
	@Autowired
	private OrderDetailsStatusRepository repository;
	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.POST)
	public @ResponseBody OrderDetailsStatus create(@RequestBody final OrderDetailsStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrderDetailsStatus", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<OrderDetailsStatus> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/OrderDetailsStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<OrderDetailsStatus> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.PUT)
	public @ResponseBody OrderDetailsStatus update(@RequestBody OrderDetailsStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrderDetailsStatus item) {
		repository.delete(item);
	}

}