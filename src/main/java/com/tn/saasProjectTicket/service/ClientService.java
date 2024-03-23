package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.ClientCriteriaDTO;
import com.tn.saasProjectTicket.entity.ClientDTO;

public interface ClientService {
	
	List<ClientDTO> getAllClients();
	ClientDTO getClient(int idClient);
	List<ClientDTO> findClientByCriteria(ClientCriteriaDTO criteria);
	
	List<ClientDTO> getClientsBySociete(int idSociete);
}
