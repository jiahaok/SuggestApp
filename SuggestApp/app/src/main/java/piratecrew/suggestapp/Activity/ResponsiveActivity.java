package piratecrew.suggestapp.Activity;

import android.os.Bundle;

/**
 * Created by Brent on 4/24/2015.
 */
public abstract class ResponsiveActivity extends AbstractActivity{
    public abstract void onWebResponse(int code, int isError);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db.setActivity(this); //Makes sure db knows what activity it is talking to
    }
}
