package main.java.company.model;

public class TicketSale implements Runnable {
    public int totalNumberOfTickets;
    private int soldByRailwayStation;
    private int soldBy12306Website;
    private int soldByCtripApp;

    public TicketSale(int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        this.sellTickets(threadName);
    }

    private void sellTickets(String threadName) {
        int interval = 0;
        while (totalNumberOfTickets != 0) {
            switch (threadName) {
                case "火车站窗口":
                    interval = 1;
                    System.out.println("通过" + threadName + "购票，余票数：" + this.totalNumberOfTickets--);
                    this.soldByRailwayStation++;
                    break;
                case "12306网站":
                    interval = 10;
                    System.out.println("通过" + threadName + "购票，余票数：" + this.totalNumberOfTickets--);
                    this.soldBy12306Website++;
                    break;
                case "携程APP":
                    interval = 5;
                    System.out.println("通过" + threadName + "购票，余票数：" + this.totalNumberOfTickets--);
                    this.soldByCtripApp++;
                    break;
                default:
                    break;
            }
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printStatistics() {
        System.out.println("\n由火车站窗口卖出的票数：" + this.soldByRailwayStation);
        System.out.println("由12306网站卖出的票数：" + this.soldBy12306Website);
        System.out.println("由携程APP卖出的票数：" + this.soldByCtripApp);
    }
}
