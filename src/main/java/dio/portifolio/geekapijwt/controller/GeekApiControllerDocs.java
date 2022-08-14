package dio.portifolio.geekapijwt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import dio.portifolio.geekapijwt.dto.request.GeekDTO;
import dio.portifolio.geekapijwt.dto.response.MessageResponseDTO;
import dio.portifolio.geekapijwt.exception.GeekAlreadyRegisteredException;
import dio.portifolio.geekapijwt.exception.GeekNotFoundException;

import javax.validation.Valid;
import java.util.List;

@Api
public interface GeekApiControllerDocs {

    @ApiOperation(value = "Geek creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success geek creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    MessageResponseDTO createGeek(GeekDTO geekDTO) throws GeekAlreadyRegisteredException;


    @ApiOperation(value = "Geek update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success geek update"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    MessageResponseDTO updateById(@PathVariable Long id, @Valid @RequestBody GeekDTO geekDTO) throws GeekNotFoundException;


    @ApiOperation(value = "Returns geek found by a given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success geek found in the system"),
            @ApiResponse(code = 404, message = "Geek with given id not found.")
    })
    GeekDTO findById(@PathVariable Long id) throws GeekNotFoundException;

    @ApiOperation(value = "Returns geek found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success geek found in the system"),
            @ApiResponse(code = 404, message = "Geek with given name not found.")
    })
    GeekDTO findByName(@PathVariable String name) throws GeekNotFoundException;

    @ApiOperation(value = "Returns a list of all geek registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all geek registered in the system"),
    })
    List<GeekDTO> listAll();

    @ApiOperation(value = "Delete a geek found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success geek deleted in the system"),
            @ApiResponse(code = 404, message = "Geek with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws GeekNotFoundException;

}
