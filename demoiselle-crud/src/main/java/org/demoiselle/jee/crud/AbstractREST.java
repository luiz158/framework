/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.crud;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.demoiselle.jee.core.api.crud.Crud;
import org.demoiselle.jee.core.api.crud.Result;

import io.swagger.annotations.ApiOperation;

/**
 * TODO JAVADOC
 *
 * @author SERPRO
 *
 * @param <T>
 * @param <I>
 */
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public abstract class AbstractREST<T, I> implements Crud<T, I> {

	@Inject
	protected AbstractBusiness<T, I> bc;

	@POST
	@Transactional
	@ApiOperation(value = "persist entity")
	@Override
	public T persist(@Valid T entity) {
		return bc.persist(entity);
	}

	@PUT
	@Transactional
	@ApiOperation(value = "full update entity")
	@Override
	public T merge(@Valid T entity) {
		return bc.merge(entity);
	}

	@DELETE
	@Path("{id}")
	@Transactional
	@ApiOperation(value = "remove entity")
	@Override
	public void remove(@PathParam("id") final I id) {
		bc.remove(id);
	}

	@GET
	@Transactional
	@Override
	public abstract Result find();
		
	@GET
	@Path("{id}")
	@Transactional
	@ApiOperation(value = "find by ID")
	@Override
	public T find(@PathParam("id") final I id) {
		return bc.find(id);
	}
}