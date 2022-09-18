package org.chatlogs.chatlogs.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.chatlogs.chatlogs.exception.MessageNotFoundException;

@Provider
public class MessageNotFoundExceptionMapper implements ExceptionMapper<MessageNotFoundException> {

	@Override
	public Response toResponse(MessageNotFoundException exception) {
		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();
	}


}
