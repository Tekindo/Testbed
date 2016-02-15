package com.gard.testbed.engine;

import com.gard.testbed.activities.Activity;
import com.gard.testbed.helpers.ActivityFactory;
import com.gard.testbed.statemachine.ActivityContext;
import com.gard.testbed.statemachine.EquipmentTaskState;
import com.gard.testbed.statemachine.IngredientsTaskState;

/**
 * Created by Chris on 14/02/2016.
 */
public class ActivityManager {

    // Holds current activity
    private Activity activity;
    // Activity context - current task state
    public ActivityContext activityContext = new ActivityContext(this);         //TODO - change back to private

    // Loads activity - for now parameterless set to load 'omelette collection' activity (two states only)
    public void loadActivity(){
        activity = ActivityFactory.newTestOmeletteActivity();
        // Initialise context to Ingredients state
        activityContext.setState(new IngredientsTaskState(this, activityContext));
    }

    public Activity getActivity(){return activity;}

    // Send event to state machine
    public void complete(String taskEntityName){
        activityContext.complete(taskEntityName);
    }


    // Prints current activity and completed status
    public void printActivity(){
        activity.print();
    }

}
