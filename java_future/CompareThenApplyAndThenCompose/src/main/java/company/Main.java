package main.java.company;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenApply(string -> string + " world");
//
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(string -> CompletableFuture.supplyAsync(() -> string + " world"));

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
