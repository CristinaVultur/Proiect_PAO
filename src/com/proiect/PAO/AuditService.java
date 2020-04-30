package com.proiect.PAO;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AuditService {
    private AuditService(){}

    public static void audit(String csvFile, String actiune) throws IOException{

        FileWriter csvOutputAudit = new FileWriter(csvFile,true);
        csvOutputAudit.append(actiune);
        csvOutputAudit.append(",");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        csvOutputAudit.append(formatter.format(ts));
        csvOutputAudit.append("\n");
        csvOutputAudit.flush();
        csvOutputAudit.close();
    }
}
