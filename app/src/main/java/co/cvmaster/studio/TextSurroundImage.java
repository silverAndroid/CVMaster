package co.cvmaster.studio;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/**
 * Created by silve_000 on 18/08/2014.
 */
class TextSurroundImage implements LeadingMarginSpan.LeadingMarginSpan2 {
    private int margin;
    private int lines;

    TextSurroundImage(int lines, int margin) {
        this.margin = margin;
        this.lines = lines;
    }

    /* Returns the value to which must be added to the indentation */
    @Override
    public int getLeadingMargin(boolean first) {
        if (first) {
            /* This padding will be applied to the number of rows returned getLeadingMarginLineCount() */
            return margin;
        } else {
            // Indent all other rows
            return 0;
        }
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {

    }

    /* Returns the number of rows which should be applied indentation returned by getLeadingMargin (true)  Note: The indentation is applied only to the N line of
    the first paragraph. */
    @Override
    public int getLeadingMarginLineCount() {
        return lines;
    }
};

