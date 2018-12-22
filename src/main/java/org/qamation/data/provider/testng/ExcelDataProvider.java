package org.qamation.data.provider.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Iterator;

public class ExcelDataProvider {
    private static Logger logger = LoggerFactory.getLogger(ExcelDataProvider.class);

    public static final String DATA_PROVIDER_CLASS_NAME="org.qamation.data.provider.DataProviderExcelAdapter";

    @Parameters({"file_name","file_tab"})
    @DataProvider(name = "external")
    public static Iterator<Object[]> getData(@Optional("amazon.xlsx")String fileName,  @Optional("0")String fileTab) {
        int tab = Integer.parseInt(fileTab);
        try {
            org.qamation.data.provider.DataProvider provider
                    = org.qamation.data.provider.DataProviderFactory.createDataProviderInstance(
                    DATA_PROVIDER_CLASS_NAME, fileName, tab);
            return provider.getDataAsIterator();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to create Test data provider",ex);
        }
    }


}
