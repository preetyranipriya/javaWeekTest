package DataBase;


import org.jfree.chart.JFreeChart;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create table in the database
            DatabaseConnector.createTable();

            // Step 2: Read Excel data
            List<YourDataModelObject> data = ExcelReader.readExcel("C:\\Users\\preety.priya\\Downloads\\Assignment2\\src\\main\\resources\\datafile.xlsx");

            // Step 3: Insert data into the database
            DatabaseConnector.insertData(data);
            DatabaseConnector.teamWithMaxInterviews();
            DatabaseConnector.teamWithMinInterviews();
            DatabaseConnector.top3Skills();
            DatabaseConnector.top3Panels();
            DatabaseConnector.skillsInPeakTime();

            // Step 4: Generate charts
            JFreeChart chart = Chart.createChart(data);

            // Step 5: Generate PDF and embed charts
            Pdf.generatePdf(data, "Output1.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
