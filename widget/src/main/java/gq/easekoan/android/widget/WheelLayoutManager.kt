package gq.easekoan.android.widget

import android.content.Context
import android.graphics.PointF
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class WheelLayoutManager @JvmOverloads constructor(var columns: Int = 1) : RecyclerView.LayoutManager(),
        RecyclerView.SmoothScroller.ScrollVectorProvider,
        ItemTouchHelper.ViewDropHandler {

    override fun prepareForDrop(view: View, target: View, x: Int, y: Int) {

    }

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF {
        return PointF(0f, 0f)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        detachAndScrapAttachedViews(recycler)
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun generateLayoutParams(c: Context, attrs: AttributeSet): RecyclerView.LayoutParams {
        return LayoutParams(c, attrs)
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams): RecyclerView.LayoutParams {
        return if (lp is ViewGroup.MarginLayoutParams) LayoutParams(lp) else LayoutParams(lp)
    }

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
        return lp is LayoutParams
    }

    class LayoutParams : RecyclerView.LayoutParams {
        companion object {
            const val OUTLINE_SQUARE = 1;
            const val OUTLINE_CIRCLE = 2;
        }

        var outline: Int = OUTLINE_SQUARE

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.WheelLayoutManager_Layout)
            outline = a.getInt(R.styleable.WheelLayoutManager_Layout_outline, OUTLINE_SQUARE)
            a.recycle()
        }

        constructor(width: Int, height: Int) : super(width, height)
        constructor(params: ViewGroup.MarginLayoutParams) : super(params)
        constructor(params: ViewGroup.LayoutParams) : super(params)
    }
}