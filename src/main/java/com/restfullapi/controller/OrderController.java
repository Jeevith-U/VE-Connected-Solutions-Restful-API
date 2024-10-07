package com.restfullapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfullapi.dto.OrderDto;
import com.restfullapi.entity.Orders;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Endpoint to save a new order.
     * @param orders - Order object that will be created.
     * @return ResponseEntity containing the ResponseStructure with the created order and HttpStatus.
     */
    @Operation(description = "To save the Orders to the Database")
    @ApiResponses(value = @ApiResponse(description = "Order saved successfully", responseCode = "201"))
    @PostMapping("/orders")
    public ResponseEntity<ResponseStructure<Orders>> saveOrder(@Valid @RequestBody Orders orders) {
        return orderService.saveOrder(orders);
    }

    /**
     * Endpoint to find an order by ID.
     * @param id - The ID of the order to be retrieved.
     * @return ResponseEntity containing the ResponseStructure with the found order or an error if not found.
     */
    @Operation(description = "Retrieve an order by its ID")
    @ApiResponses(value = {
        @ApiResponse(description = "Order found successfully", responseCode = "200"),
        @ApiResponse(description = "Order not found", responseCode = "404")
    })
    @GetMapping("/orders/{id}")
    public ResponseEntity<ResponseStructure<OrderDto>> findOrder(@PathVariable String id) {
        return orderService.findOrder(id);
    }

    /**
     * Endpoint to get all orders placed by a specific user by user ID.
     * @param id - The ID of the user whose orders will be retrieved.
     * @return ResponseEntity containing the ResponseStructure with the list of user's orders.
     */
    @Operation(description = "Retrieve all orders for a specific user by user ID")
    @ApiResponses(value = @ApiResponse(description = "Orders retrieved successfully", responseCode = "200"))
    @GetMapping("/users/{id}/orders")
    public ResponseEntity<ResponseStructure<List<Orders>>> findUsersOrder(@PathVariable String id) {
        return orderService.getUsersOrder(id);
    }

    /**
     * Endpoint to update an existing order by ID.
     * @param orders - Updated Order object with new details.
     * @param id - The ID of the order to be updated.
     * @return ResponseEntity containing the ResponseStructure with the updated order and HttpStatus.
     */
    @Operation(description = "Update an existing order by ID")
    @ApiResponses(value = @ApiResponse(description = "Order updated successfully", responseCode = "200"))
    @PutMapping("/orders/{id}")
    public ResponseEntity<ResponseStructure<Orders>> updateOrder(@Valid @RequestBody Orders orders, @PathVariable String id) {
        return orderService.updateOrder(orders, id);
    }

    /**
     * Endpoint to delete an order by ID.
     * @param orders - Order object to be deleted (Optional, could only use ID).
     * @param id - The ID of the order to be deleted.
     * @return ResponseEntity containing the ResponseStructure indicating whether the deletion was successful.
     */
    @Operation(description = "Delete an order by ID")
    @ApiResponses(value = @ApiResponse(description = "Order deleted successfully", responseCode = "200"))
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<ResponseStructure<Boolean>> deleteOrder(@Valid @RequestBody Orders orders, @PathVariable String id) {
        return orderService.deleteOrder(orders, id);
    }
}
