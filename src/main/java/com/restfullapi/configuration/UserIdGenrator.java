package com.restfullapi.configuration;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenrator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		long randomNumber = ThreadLocalRandom.current().nextLong(100000, 999999) ;
		
		String prefix = "user" ;
		
		String time = String.valueOf(Year.now().getValue()) ;
		
		return prefix + time + randomNumber ;
	}

}
