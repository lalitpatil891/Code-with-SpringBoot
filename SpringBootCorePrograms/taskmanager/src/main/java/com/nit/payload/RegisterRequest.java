package com.nit.payload;

public class RegisterRequest {
    private String username;
    private String password;
    // add email or other fields if needed

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
