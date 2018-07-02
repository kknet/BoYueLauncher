package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.bdyy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.adapter.FragmentItemAdapter;
import com.boyue.boyuelauncher.main.fragments.base.ItemBaseFragment;
import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_41;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_42;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_43;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_44;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_45;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_46;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_47;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_48;

public class HHT_zjyy_BaoDi_06_Fragment extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;
    private final ArrayList<String> videoPathList;

    public static HHT_zjyy_BaoDi_06_Fragment newInstance() {
        return new HHT_zjyy_BaoDi_06_Fragment();
    }

    public HHT_zjyy_BaoDi_06_Fragment() {
        // Required empty public constructor
        videoPathList = new ArrayList<>();
        videoPathList.add(HHT_XT_ZJYY_BAODI_41);
        videoPathList.add(HHT_XT_ZJYY_BAODI_42);
        videoPathList.add(HHT_XT_ZJYY_BAODI_43);
        videoPathList.add(HHT_XT_ZJYY_BAODI_44);
        videoPathList.add(HHT_XT_ZJYY_BAODI_45);
        videoPathList.add(HHT_XT_ZJYY_BAODI_46);
        videoPathList.add(HHT_XT_ZJYY_BAODI_47);
        videoPathList.add(HHT_XT_ZJYY_BAODI_48);
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_base_item;
    }

    @Override
    protected void init() {
        gridLayout = findViewById(R.id.gridlayout);
        fragmentItemAdapter = new FragmentItemAdapter(getContext(), 144, 144, FragmentItemAdapter.IconType.ITEM);
        gridLayout.setAdapter(fragmentItemAdapter);
        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityUtils.startBoYueVideoPlayer(videoPathList, position);
            }
        });

        callBack = new ItemDataCallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {

            }

            @Override
            public void setItemicon(final List<APPEntity> appEntities) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fragmentItemAdapter.setAppEntities(appEntities);
                    }
                });

            }
        };
        mContext = getContext();
        loadData();

    }

    //异步加载图标
    protected void loadData() {

        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                final List<APPEntity> appEntities = new ArrayList<>();
                //图标
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_baodi_items_page06_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_baodi_items_page06_text);

                for (int i = 0; i < names.length(); i++) {
                    APPEntity appEntity = new APPEntity();
                    appEntity.setNameRes(names.getResourceId(i, 0));
                    appEntity.setIconRes(icnos.getResourceId(i, 0));
                    appEntities.add(appEntity);
                }
                icnos.recycle();
                names.recycle();
                if (callBack == null) return;
                callBack.setItemicon(appEntities);
            }
        });

    }
}