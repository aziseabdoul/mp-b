package com.aa.mp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class User {

        @Id
        private String username;

        @Column
        private String password;

        public User() {
        }

        public User(String username, String password) {
            this.username = username;
            this.password = password;
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

        @Override
        public String toString() {
            //return "User{" +
                    //"username='" + username + '\'' +
                    //", password='" + password + '\'' +
                    //'}';
            return "{username=" + username + ", password=[PROTECTED]}";
    }
}