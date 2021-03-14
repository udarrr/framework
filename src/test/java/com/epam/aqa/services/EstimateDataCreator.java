package com.epam.aqa.services;

import com.epam.aqa.model.EstimateForm;
import com.epam.aqa.model.EstimateResult;

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

    public static String VM_CLASS_FIELD = "testdata.estimateform.vmClassField";
    public static String INSTANCES_TYPE_FIELD = "testdata.estimateform.instancesTypeField";
    public static String LOCAL_SSD_FIELD = "testdata.estimateform.localSSDField";
    public static String REGION_FIELD = "testdata.estimateform.regionField";
    public static String COMMITMENT_TERM_FIELD = "testdata.estimateform.commitmentTermField";

    private static String resultPriceAfterManualTest = "testdata.estimateform.resultPriceAfterManualTest";

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
