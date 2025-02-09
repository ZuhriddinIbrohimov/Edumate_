package zuhriddinscode.something.dto;

import jakarta.validation.constraints.NotBlank;

public class RegistrationDTO {

    @NotBlank(message = "name required")
    private String name;

    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "surname required")
    private String surname;

    @NotBlank(message = "password required")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}