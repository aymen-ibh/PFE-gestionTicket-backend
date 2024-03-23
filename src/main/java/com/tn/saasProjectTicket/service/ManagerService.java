package com.tn.saasProjectTicket.service;

import java.util.List;

import com.tn.saasProjectTicket.entity.ManagerCriteriaDTO;
import com.tn.saasProjectTicket.entity.ManagerDTO;

public interface ManagerService {
	
	List<ManagerDTO> getAllManagers();
	ManagerDTO getManager(int idManager);
	List<ManagerDTO> findManagerByCriteria(ManagerCriteriaDTO criteria);
	
	List<ManagerDTO> getManagersBySociete(int idSociete);
}
