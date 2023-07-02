package classes;

import java.util.Date;

public class Customer extends Person{
    private String customerId,address,phone,email;
    public Customer() {
    }
    public Customer(String name, Date dob, String gender, String customerId, String address, String phone, String email) {
        super(name, dob, gender);
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
