package com.example.mvvmdemolearningfrombilibili.taobao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemolearningfrombilibili.R
import com.example.mvvmdemolearningfrombilibili.adapter.OnSellListAdapter
import com.example.mvvmdemolearningfrombilibili.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_on_sell.*

class OnSellActivity: AppCompatActivity() {

    private val mViewModel by lazy {
        ViewModelProvider(this).get(OnSellViewModel::class.java)
    }

    private val mAdapter by lazy {
        OnSellListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_sell)
        initView()
        initObserver()
//        val viewModel = ViewModelProvider(this).get(OnSellViewModel::class.java)
//        viewModel.loadContent()

    }

    /**
     * 观察数据变化
     */
    private fun initObserver() {
        mViewModel.apply {
            contentList.observe(this@OnSellActivity, Observer {
                  // 内容列表更新
                // 更新适配器
                mAdapter.setData(it)
            })
        }.loadContent()
    }

    private fun initView() {
        contentListRv.run {
            layoutManager = LinearLayoutManager(this@OnSellActivity)
            adapter = mAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}