package com.example.demo.airlineinterface;

import java.util.List;
import com.example.demo.model.Airline;

//This is the interface where we are having the method declarations.
public interface AirlineServiceClass {

	//The class which is implements this interface will have to give definition for these methods.
	Airline createAirlineDetails(Airline airline);
	List<Airline> displayAllAirlineDetails();
	Airline  displayByAirlineId(int airline_id);
	Airline updateByAirlineId(Airline update_details,int airline_id);
	String deleteByAirlineId( int airline_id);
}