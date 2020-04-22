package listener;

import algorithms.Algorithm;
import algorithms.DTCWT;
import algorithms.NSCT;
import algorithms.NSST;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectFusionMethodListener implements ItemListener {

    private Algorithm algorithm=new NSCT();

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (ItemEvent.SELECTED==e.getStateChange()){
            String selectedItem = e.getItem().toString();
            switch (selectedItem){
                case "NSCT":
                    algorithm=new NSCT();
                    break;
                case "NSST":
                    algorithm=new NSST();
                    break;
                case "DTCWT":
                    algorithm=new DTCWT();
                    break;
                default:
                    System.out.println("未实现算法："+selectedItem);
            }
        }
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
