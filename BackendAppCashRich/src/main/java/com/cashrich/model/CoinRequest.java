package com.cashrich.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
public class CoinRequest {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    private String symbol;
	    private String response;
	    private LocalDateTime timestamp;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public CoinRequest(Long id, User user, String symbol, String response, LocalDateTime timestamp) {
			
			this.id = id;
			this.user = user;
			this.symbol = symbol;
			this.response = response;
			this.timestamp = timestamp;
		}
		public CoinRequest() {
			
		}
	    
		
	    
	    
}
