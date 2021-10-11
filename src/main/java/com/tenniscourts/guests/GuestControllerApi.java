package com.tenniscourts.guests;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;

/**
 * @author Samir Scheide
 */
@Api("Guests")
public interface GuestControllerApi {

  /**
   * Create a guest.
   * @param guest the guest information that should be used to create it.
   * @return a {@link GuestDTO}
   */
  @ApiOperation(value = "Creates a guest.", httpMethod = "POST")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Guest created.")
  })
  @ResponseStatus(value = HttpStatus.CREATED)
  ResponseEntity<GuestDTO> create(@ApiParam(value = "Guest information.", required = true) GuestCreateDTO guest);
  
  /**
   * Retrieve a list of guests.
   * @return a {@link List} of guests {@link GuestDTO}.
   * @throws GuestNotFoundException whenever a guest can`t be found using the given parameter.
   */
  @ApiOperation(value = "List all guests. Use the 'name' parameter to find matching guests.", responseContainer = "List", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Guest not found.", examples = @Example(value = {}))
  })
  ResponseEntity<List<GuestDTO>> list(@ApiParam("Guest name or part of it. If empty, return all guests.") String name) throws GuestNotFoundException;
  
  /**
   * Retrieve a single guest by its unique identifier.
   * @param id guest unique identifier.
   * @return a {@link GuestDTO} instance.
   * @throws GuestNotFoundException whenever a guest can`t be found using the given parameter.
   */
  @ApiOperation(value = "Retrieve a guest using its ID (unique identifier).", httpMethod = "GET")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Guest not found.", examples = @Example(value = {}))
  })
  ResponseEntity<GuestDTO> get(Long id) throws GuestNotFoundException;
  
  /**
   * Update the guest using the given information.
   * @param guest the guest information that should be used to ipdate it.
   * @para id {@link Guest} unique identifier.
   * @return a {@link GuestDTO} updated intance.
   * @throws GuestNotFoundException whenever a guest can`t be found using the given parameter.
   */
  @ApiOperation(value = "Update a guest using the given information", httpMethod = "PATCH")
  @ApiResponses(value = {
      @ApiResponse(code = 404, message = "Guest not found.", examples = @Example(value = {}))
  })
  ResponseEntity<GuestDTO> update(@ApiParam(value = "Guest information.", required = true) GuestUpdateDTO guest, Long id) throws GuestNotFoundException;

  /**
   * Delete a quest usinf its unique identifier.
   * @param id the {@link Guest} unique identifier.
   * @throws GuestNotFoundException whenever a guest can`t be found using the given parameter.
   */
  @ApiOperation(value = "Update a guest using the given information", httpMethod = "DELETE")
  @ApiResponses(value = {
      @ApiResponse(code = 204, message = "Guest deleted.", examples = @Example(value = {})),
      @ApiResponse(code = 404, message = "Guest not found.", examples = @Example(value = {})),
  })
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  ResponseEntity<Void> delete(Long id) throws GuestNotFoundException;
  
}
