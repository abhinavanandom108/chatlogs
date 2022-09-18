package org.chatlogs.chatlogs.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.chatlogs.chatlogs.model.Message;
import org.chatlogs.chatlogs.service.MessageService;

@Path("/")
public class MessageResource {
	private MessageService messageService = new MessageService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public Message addMessageForUser(@PathParam("userId") String userId, Message message) {
		return messageService.addMessageForUser(userId, message);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public List<Message> getAllMessagesForUser(@PathParam("userId") String userId, @QueryParam("start") int start,
			@QueryParam("limit") int limit) {
		List<Message> result = null;
		if (start > 0) {
			if (limit > 0) {
				result = messageService.getAllMessagesForUser(userId, start, limit);
			} else {
				result = messageService.getAllMessagesForUser(userId, start);
			}
		} else {
			result = messageService.getAllMessagesForUser(userId);
		}
		return result;
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{userId}")
	public String deleteAllMessagesForUser(@PathParam("userId") String userId) {
		return messageService.deleteAllMessagesForUser(userId);

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{userId}/{messageId}")
	public String deleteMessagesForUser(@PathParam("userId") String userId, @PathParam("messageId") int messageId) {
		return messageService.deleteMessageForUser(userId, messageId);

	}

}
