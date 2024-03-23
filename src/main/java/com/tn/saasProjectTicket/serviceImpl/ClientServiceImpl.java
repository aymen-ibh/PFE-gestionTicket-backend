package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.ClientCriteriaDTO;
import com.tn.saasProjectTicket.entity.ClientDTO;
import com.tn.saasProjectTicket.entity.ProjetDTO;
import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.SocieteDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<ClientDTO> getAllClients() {
		List<Client> listClients = this.clientRepository.findAll();
		return listClients.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public ClientDTO getClient(int idClient) {
		Client client = this.clientRepository.findById(idClient).orElseThrow(
				()-> new RessourceNotFoundException("Client", "Id", idClient)
				);
		return convertToDto(client);
	}
	
	@Override
	public List<ClientDTO> findClientByCriteria(ClientCriteriaDTO criteria) {
		List<Client> listClient = this.clientRepository.findByCriteria
				(criteria.getIdClient(),
			     criteria.getUsername(),
			     criteria.getEmail(),
			     criteria.getFirstName(),
			     criteria.getLastName(),
			     criteria.getBirthDate(),
			     criteria.getIsActif(),
			     criteria.getNomProjet());
		return listClient.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ClientDTO> getClientsBySociete(int idSociete) {
		List<Client> listClients = this.clientRepository.findBySocieteIdSociete(idSociete);
		return listClients.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private ClientDTO convertToDto(Client client) {		
		return  mapper.map(client, ClientDTO.class);
	}


	

}
