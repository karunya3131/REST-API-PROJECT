package com.example.demo.controllers;

import java.util.List;
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
import com.example.demo.model.Airline;
import com.example.demo.service.AirlineServiceImplementation;

/*RestController is used to create controllers for REST API's which can return JSON
 *RequestMapping annotation is used to map web requests on a particular class.
 *Also RequestMapping can be applied to the controller class as well as methods.
 */
@RestController
@RequestMapping("/Airline") 
public class AirlineController{

	//No need of Autowired annotations,if we have only one attribute.	
	public AirlineServiceImplementation airline_service;

	//Created a parameterized constructor
	public AirlineController(AirlineServiceImplementation airline_service) 
	{
		this.airline_service = airline_service;
	}

	
	/* Creating airline details 
	 * @PostMapping annotation maps HTTP POST requests into this method.	
	 * @RequestBody annotation-details given in request from user/raw(body in postman)are stored here 
	 */
	@PostMapping("/saveDetails")
	public ResponseEntity<Airline> createAirlineDetails(@RequestBody Airline airline) 
	{
		return new ResponseEntity<Airline>(airline_service.createAirlineDetails(airline), HttpStatus.CREATED);
	}

	
	/* Getting all the airline-details.
	 * @GetMapping maps the HTTP GET requests on the  method.
	 * Here we get the airline records which are in the database. 
	 */
	@GetMapping("/readAllDetails")
	public List<Airline> getAllAirlineDetails()
	{
		return airline_service.displayAllAirlineDetails();
	}

	
	/* Getting airline-details by id 
	 * @GetMapping maps the HTTP GET requests on the  method by id
	 * @ResponseEntity represents an HTTP response, including status.
	 * @PathVariable is used to set the values,like getparameter in mvc's
	 * If the request went through,a 200 OK is returned,
	 * while a 404 Not Found is returned if the resource isn't found on the server.
	 */
	@GetMapping("/readDetails/{id}")
	public ResponseEntity<Airline>getByAirlineId(@PathVariable("id") int airlineId)
	{
		return new ResponseEntity<Airline>( airline_service.displayByAirlineId(airlineId), HttpStatus.OK);
	}

	/* Updating the airline-details by id
	 * PUT HTTP method is used to update or modify the records with the help of id
	 * @PutMapping annotation is used for mapping HTTP PUT requests on the method.
	 * If the request went through,a 200 OK is returned,
	 * while a 404 Not Found is returned if the resource isn't found on the server.
	 */
	@PutMapping("/updateDetails/{id}")
	public ResponseEntity<Airline>updateDetails(@PathVariable("id") int airlineId,@RequestBody Airline airline)
	{
		return new ResponseEntity<Airline>(airline_service.updateByAirlineId(airline,airlineId), HttpStatus.OK);

	}

	/* Deleting the airline-details by id
	 * @DeleteMapping annotation maps HTTP DELETE requests on the method and delete the records with the help of id
	 * The HTTP 200 OK success status response code indicates that the request has succeeded.
	 */
	@DeleteMapping("/deleteDetails/{id}")
	public ResponseEntity <String>deleteDetails(@PathVariable("id") int airlineId)
	{
		airline_service. deleteByAirlineId(airlineId);
		return new ResponseEntity<String>(airline_service. deleteByAirlineId(airlineId), HttpStatus.OK);
	}
}


