package main.java.company;

import main.java.company.model.User;
import main.java.company.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        User zhangsan = new User(1, "张三");
        zhangsan.setCardType("农行卡");
        zhangsan.setCardId(123);
        zhangsan.setBalance(100);

        User lisi = new User(2, "李四");
        lisi.setCardType("建行卡");
        lisi.setCardId(234);
        lisi.setBalance(500);

        User wangwu = new User(3, "王五");

        List<User> users = new ArrayList<>();
        users.add(zhangsan);
        users.add(lisi);
        users.add(wangwu);

        Service service = new Service();

        CompletableFuture<String> queryResult = CompletableFuture.supplyAsync(() -> service.getCardInfor(1, users))
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + service.getCardInfor(2, users)));

        CompletableFuture<Double> totalBalance = CompletableFuture.supplyAsync(() -> service.getCountBalance(1, users))
                .thenCompose(balance -> CompletableFuture.supplyAsync(() -> balance + service.getCountBalance(2, users)));

        try {
            System.out.println(queryResult.get());
            System.out.println("\n张三和李四共有" + totalBalance.get() + "元钱");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
