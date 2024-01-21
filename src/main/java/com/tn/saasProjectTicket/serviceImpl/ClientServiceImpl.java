package com.tn.saasProjectTicket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.ClientDTO;
import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.SocieteDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

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
	
	private ClientDTO convertToDto(Client client) {
		ClientDTO dto = new ClientDTO();
		dto.setIdClient(client.getUserId());
		dto.setFirstName(client.getFirstName());
		dto.setLastName(client.getLastName());
		dto.setEmail(client.getEmail());
		dto.setUsername(client.getUsername());
		dto.setBirthDate(client.getBirthDate());
		dto.setRole(client.getRole());
		dto.setActif(client.isActif());
		dto.setCreationDate(client.getCreationDate());
		dto.setUpdateDate(client.getUpdateDate());
		
		return dto;
	}

	

}
