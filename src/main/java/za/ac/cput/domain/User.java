package za.ac.cput.domain;

public class User {
    private String user_Id;
    private String email;
    private Role role;

    public User(){
    }
    public User(Builder builder){
        this.user_Id = builder.user_Id;
        this.email = builder.email;
        this.role = builder.role;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getUser_Id() {
        return user_Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", user_Id='" + user_Id + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder {
        private String user_Id;
        private String email;
        private Role role;

        public Builder setuser_Id(String user_Id) {
            this.user_Id = user_Id;
            return this;
        }
        public Builder setemail(String email) {
            this.email = email;
            return this;
        }
        public Builder setrole(Role role) {
            this.role = role;
            return this;
        }
        public Builder copy(User user) {
            this.user_Id = user.user_Id;
            this.email = user.email;
            this.role = user.role;
            return this;
        }
        public User build() {
            return  new User(this);
        }
    }
}
