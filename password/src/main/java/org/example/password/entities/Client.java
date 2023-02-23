package org.example.password.entities;

;

public class Client {

    private Integer clientId;

    private String username;
    private String password;

    public Client() {
	// TODO Auto-generated constructor stub
    }

    public Client(Integer clientId, String username, String password) {
	super();
	this.clientId = clientId;
	this.username = username;
	this.password = password;
    }

    public Integer getClientId() {
	return clientId;
    }

    public void setClientId(Integer clientId) {
	this.clientId = clientId;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}
