package com.ticket.Entities;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TicketIdGeneration implements IdentifierGenerator{

	
	public int generateTicketId() {
		Random random=new Random();
		return random.nextInt(99999);
	}
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		return 896+this.generateTicketId();
	}

}
