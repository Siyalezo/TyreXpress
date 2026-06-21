package za.ac.cput.domain;

public class Address {
    private String address_id;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String customer_Id;

    public Address() {
    }
    public Address(Builder builder) {
        this.address_id = builder.address_id;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.customer_Id = builder.customer_Id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getStreet() {
        return street;
    }
    public String getCustomer_Id() {
        return customer_Id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id='" + address_id + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", customer_Id='" + customer_Id + '\'' +
                '}';
    }
    public static  class Builder{
        private String address_id;
        private String street;
        private String city;
        private String province;
        private String postalCode;
        private String customer_Id;

        public Builder setaddress_id(String address_id) {
            this.address_id = address_id;
            return this;
        }
        public Builder setstreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setcity(String city) {
            this.city = city;
            return this;
        }
        public Builder setprovince(String province) {
            this.province = province;
            return this;
        }
        public Builder setpostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        public Builder setcustomer_Id(String customer_Id) {
            this.customer_Id = customer_Id;
            return this;
        }

        public Builder copy(Address address){
            this.address_id = address.address_id;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.postalCode = address.postalCode;
            this.customer_Id = address.customer_Id;
            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}
