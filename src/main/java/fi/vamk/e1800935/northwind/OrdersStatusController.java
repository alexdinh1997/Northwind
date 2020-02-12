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
public class OrdersStatusController {
	@Autowired
	private OrdersStatusRepository repository;
	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.POST)
	public @ResponseBody OrdersStatus create(@RequestBody final OrdersStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrdersStatus", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<OrdersStatus> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/OrdersStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<OrdersStatus> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.PUT)
	public @ResponseBody OrdersStatus update(@RequestBody OrdersStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrdersStatus item) {
		repository.delete(item);
	}

}