package com.example.mvvmdemolearningfrombilibili.taobao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemolearningfrombilibili.domain.OnSellData
import kotlinx.coroutines.launch

class OnSellViewModel: ViewModel() {

    val contentList = MutableLiveData<List<OnSellData.TbkDgOptimusMaterialResponse.ResultList.MapData>>()

    private val onSellRepository by lazy {
        OnSellRepository()
    }

    companion object {
        // 默认第一页
        const val DEFAULT_PAGE = 1
    }

    private var mCurrentPage = DEFAULT_PAGE

    /**
     * 加载更多内容
     */
    fun loadMore() {

    }

    /**
     * 加载首页内容
     */
    fun loadContent() {
        this.listContentByPage(mCurrentPage)
    }

    private fun listContentByPage(page: Int) {
        viewModelScope.launch {
//            val onSellList = RetrofitClient.apiService.getOnSellList(page).apiData()
            val onSellList = onSellRepository.getOnSellList(page)
            println("result size ----->" + onSellList.tbk_dg_optimus_material_response.result_list.map_data.size)
            contentList.value = onSellList.tbk_dg_optimus_material_response.result_list.map_data
        }
    }


}