package io.turntabl.customers.v1.Transfers;


public class ClientTO {
    private Integer client_id;
    public String client_name;
    private String client_address;
    private String client_telephone;
    private String client_email;

    public ClientTO() {
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_telephone() {
        return client_telephone;
    }

    public void setClient_telephone(String client_telephone) {
        this.client_telephone = client_telephone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    @Override
    public String toString() {
        return "ClientTO{" +
                "client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                ", client_address='" + client_address + '\'' +
                ", client_telephone='" + client_telephone + '\'' +
                ", client_email='" + client_email + '\'' +
                '}';
    }
}
