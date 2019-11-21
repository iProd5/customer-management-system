package io.turntabl.customers.v1.Implementors;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.customers.v1.DAO.ClientDAO;
import io.turntabl.customers.v1.Transfers.ClientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Api
@RestController
public class ClientDAOImpl implements ClientDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ApiOperation("Add Client")
    @Override
    @PostMapping("/v1/api/client")
    public void addClient(@RequestBody Map<String,String> requestData) {
       jdbcTemplate.update(
               "insert into customers(client_name,client_address,client_telephone,client_email) values(?,?,?,?)",
               new Object[]{requestData.get("client_name"),requestData.get("client_address"),requestData.get("client_telephone"),requestData.get("client_email")}
       );
       System.out.println("Client Added Successfully");
    }

    @ApiOperation("Delete Client")
    @Override
    @DeleteMapping("/v1/api/client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        jdbcTemplate.update(
                "delete from customers where client_id = ?",
                new Object[]{id}
        );
        System.out.println("Client Deleted Successfully");
    }

    @ApiOperation("Get All Clients")
    @Override
    @GetMapping("/v1/api/clients")
    public List<ClientTO> getAllClients() {
        List<ClientTO> clients = jdbcTemplate.query(
                "select * from customers",
                BeanPropertyRowMapper.newInstance(ClientTO.class)
        );
        return clients;
    }

    @ApiOperation("Search Client By Name")
    @Override
    @GetMapping("/v1/api/client/search/{name}")
    public List<ClientTO> searchClientByName(@PathVariable  String name) {
        Optional<List<ClientTO>> clients = Optional.ofNullable(jdbcTemplate.query(
                "select * from customers where client_name ilike ?",
                new Object[]{name + "%"},
                BeanPropertyRowMapper.newInstance(ClientTO.class)
        ));
        if (clients.isPresent()){
            return clients.get();

        }else {
            return new ArrayList<>();
        }
    }

    public Optional<List<ClientTO>> searchClientByID(Integer clientID) {
        Optional<List<ClientTO>> client = Optional.ofNullable(jdbcTemplate.query(
                "select * from customers where client_id = ?",
                new Object[]{clientID},
                BeanPropertyRowMapper.newInstance(ClientTO.class)
        ));
        return client;
    }

    @ApiOperation("Update Client Details")
    @Override
    @PutMapping("/v1/api/client")
    public void updateClient(@RequestBody Map<String, String> requestData) {
        Integer id = Integer.parseInt(requestData.get("client_id"));
        Optional<List<ClientTO>> client = searchClientByID(Integer.parseInt(requestData.get("client_id")));

        if (client.isPresent()){
            String client_name;
            String client_address;
            String client_telephone;
            String client_email;
            if (requestData.get("client_name").isEmpty()){
                client_name = client.get().get(0).getClient_name();
            }else{
                client_name = requestData.get("client_name");
            }
            if (requestData.get("client_address").isEmpty()){
                client_address = client.get().get(0).getClient_address();
            }else{
                client_address = requestData.get("client_address");
            }
            if (requestData.get("client_telephone").isEmpty()){
                client_telephone = client.get().get(0).getClient_telephone();
            }else{
                client_telephone = requestData.get("client_telephone");
            }
            if (requestData.get("client_email").isEmpty()){
                client_email = client.get().get(0).getClient_email();
            }else{
                client_email = requestData.get("client_email");
            }

            jdbcTemplate.update(
                    "update customers set client_name = ?, client_address = ?,client_telephone = ?, client_email = ? where client_id = ?",
                    new Object[]{client_name,client_address,client_telephone,client_email,id}
            );
            System.out.println("Client Details Updated Successfully");

        }else {
            System.out.println("Client with this "+id+" ID does not exist");
        }
    }
}
