package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.airlineinterface.AirlineServiceClass;
import com.example.demo.model.Airline;
import com.example.demo.repository.AirlineRepository;

/* whenever tomcat starts this will get read by them,
 * to give definition for the implemented class
 * Service annotation can be applied only to classes.
 * It is used to mark the class as a service provider
 */
@Service
public class AirlineServiceImplementation implements AirlineServiceClass {

	/*Extended this to to connect with JPA
	 *@Autowired annotation is no need to write when only one attributes is there in a class and in autowire it checks bytype and we have that so it takes it
	 *to get reference and to use setter or construction injection we need atleast anyone type	
	 */
	public AirlineRepository airlineRepo;

	public AirlineServiceImplementation( AirlineRepository airlineRepo) {
		this.airlineRepo=airlineRepo;
	}

	/* Gave the definition for the implemented interface method 
	 * To create the airline-details we use createAirlineDetails method
	 * First it will call from here then query will run in sql like insert into values...
	 * The save() method returns the saved details
	 */
	public Airline createAirlineDetails(Airline details) {
		return  airlineRepo.save(details);  
	}

	/* To display all the records in the database we use list to show them
	 * First it will get called and select all the records and show them
	 * findAll() method allows us to get or retrieve all the entities from the database table.
	 */
	public List<Airline>displayAllAirlineDetails(){
		return  airlineRepo.findAll();
	}

	/* To display the details by id ,so we are passing the method with the id
	 * findById method retrieves by its id.
	 * Optional is a container object which may or may not contain a non-null value.
	 * If a value is present,it returns true and get returns the value.
	 * If the id is not there then it returns null.
	 */
	public Airline displayByAirlineId(int airline_id) {
		Optional<Airline> airline_detail = airlineRepo.findById(airline_id);
		if(airline_detail.isPresent()) {
			return airline_detail.get();
		}
		else {
			return null;
		}
	}


	/* To update the details by id ,so we are passing the method with the id and with the airline class
	 * findById method retrieves by its id.
	 * Optional is a container object which may or may not contain a non-null value.
	 * If a value is present,it returns true and get returns the value.
	 * First we have to get the records using id and then we have to update it.
	 * After that we have to save the record using save method.
	 * If the id is not there then it returns null.
	 */
	public Airline updateByAirlineId(Airline  update_details, int airline_id) {
		Optional<Airline> updateAirline_detail  = airlineRepo.findById(airline_id);
		if(updateAirline_detail.isPresent()) {
			Airline existingAirline = updateAirline_detail.get(); 

			existingAirline.setOrigin(update_details.getOrigin());
			existingAirline.setDestination(update_details.getDestination());
			existingAirline.setSeatingCapacity(update_details.getSeatingCapacity());
			existingAirline.setCost(update_details.getCost());
			airlineRepo.save( existingAirline);
			return existingAirline;
		}
		else {
			return null;
		}
	}

	/* To delete the details by id ,so we are passing the method with the id
	 * findById method retrieves by its its id.
	 * Optional is a container object which may or may not contain a non-null value.
	 * If a value is present,it returns true and get returns the value.
	 * If the id is present then with the help of deletebyid method we may able to delete the record
	 * Finally it return deleted ,else if the id is not there it returns not found
	 */
	public String  deleteByAirlineId( int airline_id) {
		Optional<Airline> deleteAirline_detail =  airlineRepo.findById(airline_id);
		if(deleteAirline_detail .isPresent()) {
			airlineRepo.deleteById( airline_id);
			return "deleted successfully";

		}	
		else {
			return "not found";
		}
	}
}
