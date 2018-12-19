package org.qamation.scenarios.amazon.run;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

public class ReadExcelFileTest {
    public  static final  String DATA_PROVIDER_CLASS_NAME="org.qamation.data.provider.DataProviderExcelAdapter";
    public String fileName = "amazon.xlsx";
    public int tab = 0;
    File file;


    @Parameters({"file_name","file_tab"})
    public ReadExcelFileTest(String fileName, String tab) {
        this.fileName = fileName;

    }



    private org.qamation.data.provider.DataProvider getProvider(String fileName, int tab) {
        org.qamation.data.provider.DataProvider provider
                = org.qamation.data.provider.DataProviderFactory.createDataProviderInstance(
                DATA_PROVIDER_CLASS_NAME,
                fileName,
                tab);
        return provider;
    }

    @DataProvider(name = "internal")
    public Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = getProvider(this.fileName,this.tab);
        return provider.getDataAsIterator();
    }

    @DataProvider (name = "external")
    public Iterator<Object[]> getExternalData() {
        org.qamation.data.provider.DataProvider provider = getProvider();
        return provider.getDataAsIterator();
    }


    @Test
    public void getDataProviderAsStringArray() {
        org.qamation.data.provider.DataProvider provider = getProvider();
        String[][] data =(String[][]) provider.getDataAsArray();
    }

    @Test
    public void getDataProviderAsIterator() {
        org.qamation.data.provider.DataProvider provider = getProvider();
        Iterator<Object[]> data = provider.getDataAsIterator();
        printIterator(data);

    }

    @Test(dataProvider="internal")
    public void getDataUsingInternalTestNGDataProvider(Object[] data) {
        printLine(data);
        System.out.println();
    }

    @Test(dataProvider="external")
    public void getDataUsingExternalTestNGDataProvider(Object[] data) {
        printLine(data);
        System.out.println();
    }



    private void printIterator(Iterator<Object[]> data) {
        while (data.hasNext()) {
            String[] row = (String[]) data.next();
            printLine(row);
            System.out.println();
        }
    }

    private void printLine(Object[] row) {
        for (int i = 0; i < row.length; i++)
            System.out.print(row[i]+" ");
    }







}
