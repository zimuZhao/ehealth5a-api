package api.model;

/**
 * 健康数据组合对象
 *
 * @author zimu
 * @date 2016-11-12 15:34:20 中国标准时间
 */
public class DataGroup {
    DataBloodGlucose dataBloodGlucose;
    DataBloodOxygen dataBloodOxygen;
    DataBloodPressure dataBloodPressure;
    DataBodyMassIndex dataBodyMassIndex;
    DataChol dataChol;
    DataHemoglobin dataHemoglobin;
    DataTemperature dataTemperature;
    DataUricCid dataUricCid;
    DataWaistHipRatio dataWaistHipRatio;

    public DataBloodGlucose getDataBloodGlucose() {
        return dataBloodGlucose;
    }

    public void setDataBloodGlucose(DataBloodGlucose dataBloodGlucose) {
        this.dataBloodGlucose = dataBloodGlucose;
    }

    public DataBloodOxygen getDataBloodOxygen() {
        return dataBloodOxygen;
    }

    public void setDataBloodOxygen(DataBloodOxygen dataBloodOxygen) {
        this.dataBloodOxygen = dataBloodOxygen;
    }

    public DataBloodPressure getDataBloodPressure() {
        return dataBloodPressure;
    }

    public void setDataBloodPressure(DataBloodPressure dataBloodPressure) {
        this.dataBloodPressure = dataBloodPressure;
    }

    public DataBodyMassIndex getDataBodyMassIndex() {
        return dataBodyMassIndex;
    }

    public void setDataBodyMassIndex(DataBodyMassIndex dataBodyMassIndex) {
        this.dataBodyMassIndex = dataBodyMassIndex;
    }

    public DataChol getDataChol() {
        return dataChol;
    }

    public void setDataChol(DataChol dataChol) {
        this.dataChol = dataChol;
    }

    public DataHemoglobin getDataHemoglobin() {
        return dataHemoglobin;
    }

    public void setDataHemoglobin(DataHemoglobin dataHemoglobin) {
        this.dataHemoglobin = dataHemoglobin;
    }

    public DataTemperature getDataTemperature() {
        return dataTemperature;
    }

    public void setDataTemperature(DataTemperature dataTemperature) {
        this.dataTemperature = dataTemperature;
    }

    public DataUricCid getDataUricCid() {
        return dataUricCid;
    }

    public void setDataUricCid(DataUricCid dataUricCid) {
        this.dataUricCid = dataUricCid;
    }

    public DataWaistHipRatio getDataWaistHipRatio() {
        return dataWaistHipRatio;
    }

    public void setDataWaistHipRatio(DataWaistHipRatio dataWaistHipRatio) {
        this.dataWaistHipRatio = dataWaistHipRatio;
    }
}
