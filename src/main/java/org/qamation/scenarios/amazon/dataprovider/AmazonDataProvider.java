package org.qamation.scenarios.amazon.dataprovider;

import org.qamation.data.provider.DataProviderExcelAdapter;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class AmazonDataProvider {
    private int tabNumber=0;
    private String fileName;

    public AmazonDataProvider(String file, int tab) {
        fileName = file;
        tabNumber = tab;
    }

    public AmazonDataProvider(String file) {
        fileName = file;
    }

    @DataProvider(name = "demo_scenario")
    public Object[][] getData() {
        org.qamation.data.provider.DataProvider dataProvider = new DataProviderExcelAdapter(fileName,tabNumber);
        String [] fieldNames = dataProvider.getFieldNames();
        int lines = dataProvider.getNumberOfLines();
        int column = fieldNames.length;
        Object[][] data = new String[lines][column];
        int i = 0;
        while (dataProvider.hasNext()) {
            data[0] = dataProvider.next();
            i++;
        }
        return data;

    }
}
