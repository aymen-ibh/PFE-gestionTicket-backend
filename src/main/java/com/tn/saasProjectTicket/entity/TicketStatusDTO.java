package com.tn.saasProjectTicket.entity;

public class TicketStatusDTO {
	
	private Integer idSociete;
	private String status;
    private Long ticketCount;
    
    public TicketStatusDTO(String status, Long ticketCount, Integer idSociete) {
    	this.idSociete = idSociete;
        this.status = status;
        this.ticketCount = ticketCount;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(Long ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Integer getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}
    
    
}
