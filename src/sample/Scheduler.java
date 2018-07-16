package sample;

import sample.petersonsAlgorithm.ControllerPeterson;
import sample.petersonsAlgorithm.ProcessOnePeterson;
import sample.petersonsAlgorithm.ProcessTwoPeterson;
import sample.strictAlt.ProcessOne;
import sample.strictAlt.ProcessTwo;

public class Scheduler {
    public static int turn = 0;
    public static ProcessOne processOne;
    public static ProcessTwo processTwo;

    public static ProcessOnePeterson processOnePeterson;
    public static ProcessTwoPeterson processTwoPeterson;

    private static int[] interested = new int[Constants.N];

    static public void changeTurn() {
        if (turn == 0) {
            processOne = null;
            turn = 1;
        } else {
            processTwo = null;
            turn = 0;
        }
    }

    Scheduler() {
        processOne = null;
        processTwo = null;
    }

    static public void lock(int processId, ControllerPeterson controller){

        controller.appendTextArea(processId + " TRIES TO ENTER into the critical region.\n");
        interested[processId] = Constants.TRUE;
        turn = processId;
        int other = 1 - processId;

        while (turn == processId && interested[other] == Constants.TRUE){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controller.appendTextArea(processId + " WAITING.\n");
        }
    }

    static public void unlock(int processId, ControllerPeterson controller){
        interested[processId] = Constants.FALSE;
        controller.appendTextArea(processId + " has LEFT.\n");
    }

}
