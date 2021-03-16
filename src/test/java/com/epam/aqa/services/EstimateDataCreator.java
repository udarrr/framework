package com.epam.aqa.services;

import com.epam.aqa.models.EstimateForm;
import com.epam.aqa.models.EstimateResult;

public class EstimateDataCreator {
    private static final String QUANTITY_INSTANCES = "testdata.computerEngineForm.quantityInstances";
    private static final String OPERATION_SYSTEM_ID = "testdata.computerEngineForm.operationSystemID";
    private static final String MACHINE_CLASS_ID = "testdata.computerEngineForm.machineClassID";
    private static final String SERIES_ID = "testdata.computerEngineForm.seriesID";
    private static final String MACHINE_TYPE_ID = "testdata.computerEngineForm.machineTypeID";
    private static final String GPU_QUANTITY_ID = "testdata.computerEngineForm.gpuQuantityID";
    private static final String GPU_TYPE_ID = "testdata.computerEngineForm.gpuTypeID";
    private static final String LOCALSSD_ID = "testdata.computerEngineForm.localSSDID";
    private static final String DATA_CENTER_LOCATION_ID = "testdata.computerEngineForm.dataCenterLocationID";
    private static final String COMMITTED_USAGE_ID = "testdata.computerEngineForm.committedUsageID";

    public static String VM_CLASS_FIELD = "testdata.computerEngineForm.vmClassField";
    public static String INSTANCES_TYPE_FIELD = "testdata.computerEngineForm.instancesTypeField";
    public static String LOCAL_SSD_FIELD = "testdata.computerEngineForm.localSSDField";
    public static String REGION_FIELD = "testdata.computerEngineForm.regionField";
    public static String COMMITMENT_TERM_FIELD = "testdata.computerEngineForm.commitmentTermField";

    private static final String resultPriceAfterManualTest = "testdata.computerEngineForm.resultPriceAfterManualTest";

    public static EstimateForm getEstimateFormData() {
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

    public static EstimateResult getEstimateResultFields() {
        EstimateResult estimateResult = new EstimateResult();

        estimateResult.setVmClassField(TestDataReader.getCommonData(VM_CLASS_FIELD));
        estimateResult.setInstanceTypeField(TestDataReader.getCommonData(INSTANCES_TYPE_FIELD));
        estimateResult.setLocalSSDField(TestDataReader.getCommonData(LOCAL_SSD_FIELD));
        estimateResult.setRegionField(TestDataReader.getCommonData(REGION_FIELD));
        estimateResult.setCommitmentTermField(TestDataReader.getCommonData(COMMITMENT_TERM_FIELD));

        return estimateResult;
    }
}
