package com.example.intoin.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.fragment.holder.MainSearchCategoryRow;
import com.example.intoin.myapplication.fragment.holder.MainSearchCategoryRowHolder;
import com.example.intoin.myapplication.fragment.holder.MainSearchItemHolder;
import com.example.intoin.myapplication.util.Util;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

/**
 * Created by choeseong-geun on 15. 11. 18..
 */
public class MainSearchModelFragment extends Fragment implements View.OnClickListener{
    private AndroidTreeView tView;
    private Button customer_add_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_frag, null, false);
        final ViewGroup containerView = (ViewGroup) v.findViewById(R.id.container);
        final TreeNode root = TreeNode.root();

        TreeNode model_search = new TreeNode(new MainSearchCategoryRow.GroupCategoryItem("모델하우스 결과","2")).setViewHolder(new MainSearchCategoryRowHolder(getActivity()));


//        데이터 셋

        modelCategory(model_search);


        root.addChildren(model_search);

        tView = new AndroidTreeView(getActivity(), root);
        tView.setDefaultAnimation(true);
        tView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);

        tView.setDefaultNodeClickListener(new TreeNode.TreeNodeClickListener() {
            @Override
            public void onClick(TreeNode node, Object value) {

//                MainTreeItemHolder text = (MainTreeItemHolder) node.getViewHolder().getNodeItemsView().getTag();





//                Toast.makeText(getActivity(), node.getId() + "////"+value.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        containerView.addView(tView.getView());

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString("tState");
            if (!TextUtils.isEmpty(state)) {
                tView.restoreState(state);
            }
        }
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();




    }




    private void modelCategory(TreeNode profile) {



        TreeNode model = new TreeNode(new MainSearchItemHolder.LayoutInfo("MODEL","테스트","테스트","테스트","테스트","테스트","테스트")).setViewHolder(new MainSearchItemHolder(getActivity()));
        TreeNode models = new TreeNode(new MainSearchItemHolder.LayoutInfo("MODEL","테스트","테스트","테스트","테스트","테스트","테스트")).setViewHolder(new MainSearchItemHolder(getActivity()));



        profile.addChildren(model, models);
    }

















    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.customer_add_bt:
                Util.CustomerAddePop(getActivity(), getActivity());
                break;
        }
    }
}
