import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class ProcessControlBlock {

    private final int pid;
    private ProcessState state;
    // the following two ArrayLists should record when the process starts/stops
    // for statistical purposes
    private ArrayList<Integer> startTimes; // when the process starts running
    private ArrayList<Integer> stopTimes;  // when the process stops running

    private static int pidTotal= 0;

    public ProcessControlBlock() {
        this.state = ProcessState.NEW;
        this.startTimes = new ArrayList<Integer>();
        this.stopTimes = new ArrayList<Integer>();
        /* TODO: you need to add some code here
         * Hint: every process should get a unique PID */
        Random r =new Random();
        this.pid =  r.nextInt(1000) + 1 ;// change this line


    }

    public ProcessState getState() {
        return this.state;
    }

    public void setState(ProcessState state, int currentClockTime) {
        /* TODO: you need to add some code here
         * Hint: update this.state, but also include currentClockTime
         * in startTimes/stopTimes */

        this.state=state;
        if (state == ProcessState.RUNNING)
            startTimes.add(currentClockTime);

        if(state == ProcessState.TERMINATED || state == ProcessState.READY)
            stopTimes.add(currentClockTime);



    }

    public int getPid() {
        return this.pid;
    }

    public ArrayList<Integer> getStartTimes() {
        return startTimes;
    }

    public ArrayList<Integer> getStopTimes() {
        return stopTimes;
    }

}
