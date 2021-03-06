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
public class PurchaseOrderStatusController {
	@Autowired
	private PurchaseOrderStatusRepository repository;
	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrderStatus create(@RequestBody final PurchaseOrderStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/PurchaseOrderStatus", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<PurchaseOrderStatus> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/PurchaseOrderStatus/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<PurchaseOrderStatus> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.PUT)
	public @ResponseBody PurchaseOrderStatus update(@RequestBody PurchaseOrderStatus item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody PurchaseOrderStatus item) {
		repository.delete(item);
	}

}