package sample.strictAlt;

import sample.Scheduler;

public class ProcessOne extends Thread {
    int processId;
    private Controller controller;

    ProcessOne(Controller controller) {
        this.controller = controller;
        processId = 0;
    }

    @Override
    public void run() {
        try {
            while (Scheduler.turn != processId) {
                controller.appendTextArea("Process " + processId + " TRIES TO ENTER into the critical region.\n");
                Thread.sleep(2000);
            }

            controller.appendTextArea("Process " + processId + " HAS ENTERED into the critical region.\n");
            for (int i = 0; i < 10; i++) {
                controller.appendTextArea(String.valueOf(i) + '\n');
                Thread.sleep(2000);
            }

        }catch (InterruptedException ignored) {
        }

        Scheduler.changeTurn();
        controller.appendTextArea("Process " + processId + " CAME OUT from the critical region.\n");
    }


}

