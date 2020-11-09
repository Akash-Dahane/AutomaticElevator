/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiita.gproject.automaticelevatorsys;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author bluelord
 */
public class Logs {
    public Logs(Initiate obj) throws IOException{
        int wt = obj.wt;
        int f = obj.f;
        int n =obj.n;
        String status = obj.statLabel.getText();
        LogManager lm = LogManager.getLogManager();
        String LoggerName = Logger.GLOBAL_LOGGER_NAME;
        Logger logrep = lm.getLogger(LoggerName);
        logrep.setLevel(Level.INFO);
        logrep.setUseParentHandlers(false);
        
        FileHandler fh = new FileHandler("logreports.log",0,1,true);
        fh.setFormatter(new SimpleFormatter());
        fh.setLevel(Level.INFO);
        logrep.addHandler(fh);
        logrep.log(Level.INFO, "\nWeight in lift:{0}\nNumber of people:{1}\nFloor no:{2}\nOverall Status:{3}", new Object[]{wt, n, f, status});
        fh.flush();
        fh.close();
    }
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        
       
        
    }
    
}
