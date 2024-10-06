package com.restfullapi.configuration;


/*
 * This class is used to generate custom Order ID.  
 * Prefixe is Ord and the Random number will be generated between 10000 to 99000. 
 * And it will be added with the current year. 
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenrator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		long randomNumber = ThreadLocalRandom.current().nextLong(10000, 99999) ;
		
		String prefix = "ord" ;
		
		String time = String.valueOf(Year.now().getValue()) ;
		
		return prefix + time + randomNumber ;
	}

}
