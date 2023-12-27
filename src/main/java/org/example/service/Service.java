package org.example.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.example.Main;
import org.example.model.Unit;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    public void generateReport() {
        List<Unit> unitList = new ArrayList<>();
        unitList.add(new Unit("111111", "2111122222", "3333333333"));
        unitList.add(new Unit("aaaaaaa", "2111122222", "3333333333"));
        unitList.add(new Unit("sssssss", "2111122222", "3333333333"));
        unitList.add(new Unit("ddddddddddddd ffffffffffff gggg", "2111122222", "3333333333"));
        unitList.add(new Unit("zzzzzzzzzz x cccccccc", "2111122222", "3333333333"));

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(getReportAsStream());
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(unitList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Websparrow.org");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("d:\\1.docx")));
            exporter.exportReport();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    private InputStream getReportAsStream() {

        InputStream s;

        try {
            s = Main.class.getResourceAsStream("/reports.jasper/report1.jrxml");
        } catch (Exception e) {
            e.printStackTrace();
            s = null;
        }

        return s;
    }
}
