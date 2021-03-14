package com.epam.aqa.service;

import com.epam.aqa.model.EstimateForm;

public class EstimateDataCreator {
    private static final String QUANTITY_INSTANCES = "testdata.estimateform.quantityInstances";
    private static final String OPERATION_SYSTEM_ID = "testdata.estimateform.operationSystemID";
    private static final String MACHINE_CLASS_ID = "testdata.estimateform.machineClassID";
    private static final String SERIES_ID = "testdata.estimateform.seriesID";
    private static final String MACHINE_TYPE_ID = "testdata.estimateform.machineTypeID";
    private static final String GPU_QUANTITY_ID = "testdata.estimateform.gpuQuantityID";
    private static final String GPU_TYPE_ID = "testdata.estimateform.gpuTypeID";
    private static final String LOCALSSD_ID = "testdata.estimateform.localSSDID";
    private static final String DATA_CENTER_LOCATION_ID = "testdata.estimateform.dataCenterLocationID";
    private static final String COMMITTED_USAGE_ID = "testdata.estimateform.committedUsageID";

    public static String vmClassField;
    public static String instanceTypeField;
    public static String regionField;
    public static String localSSDField;
    public static String commitmentTermField;

    private static String resultPriceAfterManualTest;
    private static String resultPriceFromCalculator;

    private static String descriptionPriceField;


    public EstimateForm getEstimateFormData() {
        EstimateForm estimateForm = new EstimateForm();
        estimateForm.setQuantityInstances(TestDataReader.getCommonData(QUANTITY_INSTANCES));
        estimateForm.setOperationSystemID(TestDataReader.getCommonData(OPERATION_SYSTEM_ID));
        estimateForm.setMachineClassID(TestDataReader.getCommonData(MACHINE_CLASS_ID));
        estimateForm.setSeriesID(TestDataReader.getCommonData(SERIES_ID));
        estimateForm.setMachineTypeID(TestDataReader.getCommonData(MACHINE_TYPE_ID));
        estimateForm.setGpuQuantityID(TestDataReader.getCommonData(GPU_QUANTITY_ID));
        estimateForm.setGpuTypeID(TestDataReader.getCommonData(GPU_TYPE_ID));
        estimateForm.setLocalSSDID(TestDataReader.getCommonData(LOCALSSD_ID));
        estimateForm.setDataCenterLocationID(TestDataReader.getCommonData(DATA_CENTER_LOCATION_ID));
        estimateForm.setCommittedUsageID(TestDataReader.getCommonData(COMMITTED_USAGE_ID));

        return estimateForm;
    }

    public EstimateForm getEstimateResultFields() {
        EstimateForm estimateForm = new EstimateForm();
        public static String vmClassField;
        public static String instanceTypeField;
        public static String regionField;
        public static String localSSDField;
        public static String commitmentTermField;

        return estimateForm;
    }
}
