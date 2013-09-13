package com.lordofthejars.bank;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class Resources {

//	@PersistenceContext
//	@Produces
//	private EntityManager em;
	
	@Produces
	FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}
