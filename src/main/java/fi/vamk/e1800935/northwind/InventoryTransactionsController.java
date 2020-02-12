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
public class InventoryTransactionsController {
	@Autowired
	private InventoryTransactionsRepository repository;
	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.POST)
	public @ResponseBody InventoryTransactions create(@RequestBody final InventoryTransactions item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/InventoryTransactions", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<InventoryTransactions> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/InventoryTransactions/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<InventoryTransactions> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.PUT)
	public @ResponseBody InventoryTransactions update(@RequestBody InventoryTransactions item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.DELETE)
	public void delete(@RequestBody InventoryTransactions item) {
		repository.delete(item);
	}

}