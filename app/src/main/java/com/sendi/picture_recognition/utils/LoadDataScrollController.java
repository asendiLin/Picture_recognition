package com.sendi.picture_recognition.utils;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by Administrator on 2017/4/20.
 */

public class LoadDataScrollController extends RecyclerView.OnScrollListener implements SwipeRefreshLayout.OnRefreshListener {

    public enum LayoutManagerType {
        LINEAR_LAYOUT,
        GRID_LAYOUT,
        STAGGERED_GRID_LAYOUT
    }

    /**
     * 当前布局管理器的类型
     */
    private LayoutManagerType mLayoutManagerType;

    /**
     * 当前RecyclerView显示的最大条目
     */
    private int mLastVisibleItemPosition;

    /**
     * 每列的最后一个条目
     */
    private int[] mLastPositions;

    /**
     * 是否正在加载数据  包括刷新和向上加载更多
     */
    private boolean isLoadData = false;

    /**
     * 回调接口
     */
    private OnRecyclerRefreshListener mOnRecyclerRefreshListener;

    public LoadDataScrollController(OnRecyclerRefreshListener onRecyclerRefreshListener) {
        mOnRecyclerRefreshListener = onRecyclerRefreshListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        /**
         * 获取布局参数
         */
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        //如果为空，第一次运行，确定布局类型
        if (mLayoutManagerType == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                mLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT;
            } else if (layoutManager instanceof GridLayoutManager) {
                mLayoutManagerType = LayoutManagerType.GRID_LAYOUT;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                mLayoutManagerType = LayoutManagerType.STAGGERED_GRID_LAYOUT;
            } else {
                throw new RuntimeException("LayoutManager must be LinearLayoutManager," +
                        "GridLayoutManager,StaggeredGridLayoutManager");
            }
        }
        switch (mLayoutManagerType) {
            case LINEAR_LAYOUT:
                mLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                break;
            case GRID_LAYOUT:
                mLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                break;
            case STAGGERED_GRID_LAYOUT:
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (mLastPositions == null) {
                    mLastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(mLastPositions);
                    mLastVisibleItemPosition = findMax(mLastPositions);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();

        //RecyclerView显示的条目
        int visibleCount=layoutManager.getChildCount();

        //显示数据总数
        int totalCount=layoutManager.getItemCount();

        // 四个条件，分别是是否有数据，状态是否是滑动停止状态，显示的最大条目是否大于整个数据（注意偏移量），是否正在加载数据
        if (visibleCount>0&&
                newState== RecyclerView.SCROLL_STATE_IDLE&&
                mLastVisibleItemPosition>=totalCount-1&&
                !isLoadData){
            if (mOnRecyclerRefreshListener!=null){
                //加载更多
                isLoadData=true;
                mOnRecyclerRefreshListener.onLoadMore();
            }
        }
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public void setLoadDataStatus(boolean isLoadData){
        this.isLoadData = isLoadData;
    }

    @Override
    public void onRefresh() {
        if (mOnRecyclerRefreshListener!=null){
            //刷新数据
            isLoadData=true;
            mOnRecyclerRefreshListener.onRefresh();
        }
    }
    public interface OnRecyclerRefreshListener {

        void onRefresh();
        void onLoadMore();

    }
}
