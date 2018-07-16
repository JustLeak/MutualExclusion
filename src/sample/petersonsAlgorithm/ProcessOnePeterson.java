package sample.petersonsAlgorithm;

import sample.Scheduler;

public class ProcessOnePeterson extends Thread {
    private int processId;
    private ControllerPeterson controllerPeterson;

    ProcessOnePeterson(ControllerPeterson controller) {
        controllerPeterson = controller;
        processId = 0;
    }

    @Override
    public void run() {

        Scheduler.lock(processId, controllerPeterson);

        controllerPeterson.appendTextArea(processId + " has ENTERED into a critical region.\n");
        for (int i = 0; i < 5; i++) {

            controllerPeterson.appendTextArea("Hi. Im process " + processId + "\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Scheduler.unlock(processId, controllerPeterson);
    }
}

