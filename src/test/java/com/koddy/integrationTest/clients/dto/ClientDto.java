package com.koddy.integrationTest.clients.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    /**
     * TEMPLATE
     * {
     *     "name": "client demo",
     *     "nit": "38464",
     *     "address": "address",
     *     "legal_representative": "ceo",
     *     "phone": "2383",
     *     "email": "amail@gmail.com",
     *     "description": "good client"
     * }
     */
    private Integer id;
    private String nit;
    private String name;
    private String address;
    private String legalRepresentative;
    private String phone;
    private  String email;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(nit, clientDto.nit) && Objects.equals(name, clientDto.name) && Objects.equals(description, clientDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nit, name, description);
    }
}
