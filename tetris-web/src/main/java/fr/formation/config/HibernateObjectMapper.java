package fr.formation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateObjectMapper extends ObjectMapper
{
	private static final long serialVersionUID = 1L;
	
	public HibernateObjectMapper() {
		this.registerModule(new Hibernate5Module());
	}
}
