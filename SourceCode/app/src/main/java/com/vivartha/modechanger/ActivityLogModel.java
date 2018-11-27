package com.vivartha.modechanger;

import java.io.Serializable;

/**
 * Created by sai krishna
 * This is an activity log controller
 * It triggers the changes made, and stores that into database
 * The stored content will be displayed to the user once the user opens the activity.
 * since this is the launch activity, the user will be navigated to this once he enters the correct pin.
 **/

public class ActivityLogModel implements Serializable {

    public  String option_code = "";
    public  String activity_log_desc = "";
    public  String date_time = "";

    public ActivityLogModel(String option_code, String activity_log_desc, String date_time) {
        this.option_code = option_code;
        this.activity_log_desc = activity_log_desc;
        this.date_time = date_time;
    }

    public ActivityLogModel() { }

    public ActivityLogModel addItems (ActivityLogModel mandalModel){
        return new ActivityLogModel(mandalModel.option_code,
                mandalModel.activity_log_desc, mandalModel.date_time);
    }

    public String getOption_code() {
        return option_code;
    }

    public void setOption_code(String option_code) {
        this.option_code = option_code;
    }

    public String getActivity_log_desc() {
        return activity_log_desc;
    }

    public void setActivity_log_desc(String activity_log_desc) {
        this.activity_log_desc = activity_log_desc;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
