package main.java.company;

import main.java.company.model.TicketSale;

public class Main {

    public static void main(String[] args) {
        TicketSale ticketSale = new TicketSale(500);
        Thread railwayStationThread = new Thread(ticketSale, "火车站窗口");
        Thread webSiteOf12306Thread = new Thread(ticketSale, "12306网站");
        Thread ctripAppThread = new Thread(ticketSale, "携程APP");

        railwayStationThread.start();
        webSiteOf12306Thread.start();
        ctripAppThread.start();

        try {
            railwayStationThread.join();
            webSiteOf12306Thread.join();
            ctripAppThread.join();
            ticketSale.printStatistics();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
