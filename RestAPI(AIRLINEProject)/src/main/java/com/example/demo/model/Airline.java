package com.example.demo.model;

import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//Entity annotation defines that a class can be mapped to a table
@Entity(name="Airline_Table")
@DynamicUpdate
public class Airline {

	/* @Id must be given to the entity classes, in which makes
	 * the attributes to act as primary key.In @GeneratedValue, what
	 * type of primary key to be generated is given in it. Here,primary key
	 * type IDENTITY is given which starts by 1 and increments by 1.
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airlineId;
	private String airlineName;
	private String origin;
	private String destination;
	private Integer seatingCapacity;
	private Integer cost;


	/*Here we used setter method for all the attributes to set the value
	 *This keyword is refers to the current class object and also 
	 *as the names are similar we used this keyword.
	 *Here we used getter method for  all the attributes to return it's value.
	 */
	public String getAirlineName() {
		return  airlineName;
	}
	public void setAirlineName(String airlineName) {
		this. airlineName =  airlineName;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String source ) {
		this.origin = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination ) {
		this. destination=  destination;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity= seatingCapacity;
	}
	public Integer getCost() {
		return  cost;
	}
	public void setCost(Integer cost) {
		this. cost=cost;
	}

}