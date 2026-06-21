package za.ac.cput.domain;

public class Customer {
    private String customer_Id;
    private String firstName;
    private String lastName;
    private String email;
    private String user_Id;

    public Customer() {
    }
    public Customer(Builder builder) {
        this.customer_Id = builder.customer_Id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.user_Id = builder.user_Id;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUser_Id() {
        return user_Id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customer_Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", user_Id='" + user_Id + '\'' +
                '}';
    }
    public static class  Builder {
        private String customer_Id;
        private String firstName;
        private String lastName;
        private String email;
        private String user_Id;

        public Builder setcustomer_Id(String customer_Id) {
            this.customer_Id = customer_Id;
            return this;
        }
        public Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setlastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setemail(String email) {
            this.email = email;
            return this;
        }
        public Builder setuser_Id(String user_Id) {
            this.user_Id = user_Id;
            return this;
        }
        public Builder copy(Customer customer) {
            this.customer_Id = customer.getCustomer_Id();
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
            this.email = customer.getEmail();
            this.user_Id = customer.getUser_Id();
            return this;
        }
        public Customer build() {
            return new Customer(this);
        }

    }
}
