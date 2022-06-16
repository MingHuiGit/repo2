package cn.itcast.domain;

import java.io.Serializable;

public class paramodel implements Serializable {
    String username;
    String password;
    Double money;

    @Override
    public String toString() {
        return "paramodel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +

                '}';
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
