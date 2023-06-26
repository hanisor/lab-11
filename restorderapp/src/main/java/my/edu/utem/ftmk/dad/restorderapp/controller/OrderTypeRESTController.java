package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;

@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {

	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId)
	{
		orderTypeRepository.deleteById(orderTypeId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Lab Week 11 Task 2 - Find Order Type by Name
	 * 
	 * @param orderType
	 * @return A list of order types record.
	 */
	@RequestMapping("/find/name")
	public List<OrderType> findOrderType (@RequestBody OrderType orderType)
	{
		List<OrderType> orderTypes = orderTypeRepository.findByNameContaining(orderType.getName());
		return orderTypes;
	}
	
	/*
	 * Lab Week 11 Task 3 - Find Order Type by Code
	 * 
	 * @param partCode
	 * @return A list of order types record.
	 */
	@RequestMapping("/find/code/{partCode}")
	public List<OrderType> findOrderType(@PathVariable String partCode)
	{
		List<OrderType> orderTypes = orderTypeRepository.findByCodeStartingWith(partCode);
		return orderTypes;
	}
	
	/*
	 * Lab Week 11 Task 4 - Count Order Type Data
	 * 
	 * @return A long data type of number
	 */
	@RequestMapping("/count")
	public long countOrderType()
	{
		long number = orderTypeRepository.count();
		return number;
	}
	
	/*
	 * Lab Week 11 Task 5 - Retrieve a sorted Order Type Data
	 * 
	 * @param orderType
	 * @return A list of order type data
	 */
	@GetMapping("/asc")
	public List<OrderType> findSortedOrderTypeName()
	{
		return orderTypeRepository.findByOrderByNameAsc();
	}
	
	
	/*
	 * Lab Week 11 Task 8.2
	 * 
	 * 
	 * @return A list of objects where value of each field in separated arrays
	 */
	@GetMapping("/find/pickup/raw")
	public List<Object[]> getRawPickUpOrderCode(){
		
		// Execute query method
		List<Object[]> objOrderTypes = orderTypeRepository.selectCustomByCode();
		
		// For debugging purpose
		for(Object[] objOrderType: objOrderTypes) {
			
			for(Object currentObject: objOrderType) {
				
				System.out.println(currentObject.toString());
			}
		}
		
		return objOrderTypes;
	}
		
	
	/**
	 * Lab Week 11 Task 8.4
	 * 
	 * @return A list of objects where result of query execution wrap in
	 * OrderType
	 */
	@GetMapping("/find/pickup/wrap")
	public List<OrderType> getWrapPickUpOrderCode() {
		
		// Execute query method
		List<Object[]> objOrderTypes = orderTypeRepository.selectCustomByCode();
		
		// Wrap result in a list of order type
		List<OrderType> orderTypes = new ArrayList<OrderType>();
		for (Object[] objOrderType:objOrderTypes) {
			
			// Wrap in order type
			OrderType orderType = new OrderType();
			orderType.setCode(objOrderType[0].toString());
			orderType.setName(objOrderType[1].toString());
			
			// Add into list
			orderTypes.add(orderType);
		}
		
		return orderTypes;
	}
	
	
	@GetMapping
	public List<OrderType> getOrderTypes()
	{
		return orderTypeRepository.findAll();
		
	}
	
	@GetMapping("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId)
	{
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		
		return orderType;
	}
	
	@PostMapping
	public OrderType insertOrderType(@RequestBody OrderType orderType)
	{
		return orderTypeRepository.save(orderType);
	}
	
	@PutMapping
	public OrderType updateOrderType(@RequestBody OrderType orderType)
	{
		return orderTypeRepository.save(orderType);
	}
}