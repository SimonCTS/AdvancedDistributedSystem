package se.kth.ict.id2203;

import se.sics.kompics.launch.Scenario;
import se.sics.kompics.launch.Topology;

/**
 *
 * @author ALEX
 */
public class Assignment3abExecutor {
   /**
     * The main method.
     *
     * @param args the arguments
     */
    public static final void main(String[] args) {

       Topology topologyEx3 = new Topology() {
            {
                node(1, "127.0.0.1", 22031);
                node(2, "127.0.0.1", 22032);
                node(3, "127.0.0.1", 22033);
                
                link(1, 2, 1000, 0).bidirectional();
                link(1, 3, 2000, 0).bidirectional();
                link(2, 3, 1750, 0).bidirectional();
            }
        };
        
        
        Scenario scenario3 = new Scenario(Assignment3bMain.class){
            {
                command(1, "");
                command(2, "", 100);
                command(3, "", 200);
            }
        };


        Scenario scenario1 = new Scenario(Assignment2Main.class) {
            {
                for (int i = 1; i <= 10; i++) {
                    command(i, "Bmsgfrom"+i+":S1500:Bother_msg_from"+i);
                    
                }
                
            }
        };

        Scenario scenario2 = new Scenario(Assignment1aMain.class) {
            {
                command(1, "S2500:La1:S300:PA1:X").recover("S400:Pff", 1000);
                command(2, "S2500:Pb2:S300:LB2");
                command(3, "S2500:Lc3:S300:PC3");
                command(4, "S2500:Pd4:S300:LD4");
            }
        };

        

        //scenarioPfd.executeOn(topology2);
        //scenario1.executeOn(topology2);
        scenario3.executeOn(topologyEx3);
        //scenario1.executeOn(topology2);
        // scenario2.executeOn(topology1);
        // scenario2.executeOn(topology2);
        // scenario1.executeOnFullyConnected(topology1);
        // scenario1.executeOnFullyConnected(topology2);
        // scenario2.executeOnFullyConnected(topology1);
        // scenario2.executeOnFullyConnected(topology2);

        System.exit(0);
        // move one of the below scenario executions above the exit for
        // execution

    }
}