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
public class PurchaseOrderDetailsController {
	@Autowired
	private PurchaseOrderDetailsRepository repository;
	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrderDetails create(@RequestBody final PurchaseOrderDetails item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/PurchaseOrderDetails", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<PurchaseOrderDetails> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return repository.findAll();
	}

	@RequestMapping(value = "/PurchaseOrderDetails/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Optional<PurchaseOrderDetails> get(@PathVariable("id") final int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.PUT)
	public @ResponseBody PurchaseOrderDetails update(@RequestBody PurchaseOrderDetails item) {
		return repository.save(item);
	}

	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.DELETE)
	public void delete(@RequestBody PurchaseOrderDetails item) {
		repository.delete(item);
	}

}