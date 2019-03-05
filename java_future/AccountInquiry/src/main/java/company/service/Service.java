package main.java.company.service;

import main.java.company.model.User;

import java.util.List;

public class Service {
    public User getUserInfor(long id, List<User> users) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public double getCountBalance(long id, List<User> users) {
        return this.getUserInfor(id, users).getBalance();
    }

    public String getCardInfor(long id, List<User> users) {
        User user = this.getUserInfor(id, users);
        return "\n"
            + user.getName()
            + "的卡类型为："
            + user.getCardType()
            + "，余额为："
            + user.getBalance();
    }
}
