package io.turntabl.customers.v1.DAO;

import io.turntabl.customers.v1.Transfers.ClientTO;
import java.util.List;
import java.util.Map;

public interface ClientDAO {
    public void addClient(Map<String,String> requestData);
    public void deleteClient(Integer clientID);
    public List<ClientTO> getAllClients();
    public List<ClientTO> searchClientByName(String clientName);
    public void updateClient(Map<String,String> requestData);
}
