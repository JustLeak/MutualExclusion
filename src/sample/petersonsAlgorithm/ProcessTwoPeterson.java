package sample.petersonsAlgorithm;

import sample.Scheduler;

public class ProcessTwoPeterson extends Thread {
    private int processId;
    private ControllerPeterson controllerPeterson;

    ProcessTwoPeterson(ControllerPeterson controller) {
        controllerPeterson = controller;
        processId = 1;
    }

    @Override
    public void run() {
        Scheduler.lock(processId, controllerPeterson);

        controllerPeterson.appendTextArea(processId + " has entered into a critical region.\n");
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

