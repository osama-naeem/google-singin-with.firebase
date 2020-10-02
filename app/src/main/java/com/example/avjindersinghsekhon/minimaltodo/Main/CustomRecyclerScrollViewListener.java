package com.example.avjindersinghsekhon.minimaltodo.Main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

 public abstract class CustomRecyclerScrollViewListener extends
        RecyclerView.OnScrollListener {

     /**
     *comment.
     */

   private int scrollDist = 0;
     /**
      *comment.
      */
 private boolean isVisible = true;
     /**
      *comment.
      */
    static final float MINIMUM = 20;
     @Override
  public void onScrolled(final RecyclerView recyclerView,
                           final int dx, final int dy) {
        super.onScrolled(recyclerView, dx, dy);
//        Log.d("OskarSchindler", "Scroll Distance "+scrollDist);
        if (isVisible && scrollDist > MINIMUM) {
            Log.d("OskarSchindler", "Hide " + scrollDist);
            hide();
            scrollDist = 0;
            isVisible = false;
        } else if (!isVisible && scrollDist < -MINIMUM) {
            Log.d("OskarSchindler", "Show " + scrollDist);
            show();
            scrollDist = 0;
            isVisible = true;
        }
        if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {
            Log.d("OskarSchindler", "Add Up " + scrollDist);
            scrollDist += dy;
        }
    }
     /**
      *comment.
      */
     public abstract void show();
     /**
      *comment.
      */
    public abstract void hide();
}
