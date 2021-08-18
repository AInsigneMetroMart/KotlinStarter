package io.ainsigne.stores

import android.content.Intent
import android.os.Bundle
import io.ainsigne.kotlinstarter.injection.app.InjectUtils
import io.ainsigne.kotlinstarter.view.BaseActivity
import io.ainsigne.stores.adapter.StoreCenterAdapter
import io.ainsigne.stores.databinding.ActivityStoresBinding
import timber.log.Timber
import javax.inject.Inject

class StoresActivity : BaseActivity() {
    private lateinit var binding: ActivityStoresBinding
    @Inject
    lateinit var viewModel: StoresViewModel

    private var areaId = "131"

    var adapter : StoreCenterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoresBinding.inflate(layoutInflater)

        setContentView(binding.root)
        adapter = StoreCenterAdapter(ArrayList()) {
            val args = Bundle().apply {
                this.putString(shopId, it.id)
            }
            startActivity(Intent(prepareIntent(activityHome, args)))
        }
        binding
            .apply {
                viewModel = this@StoresActivity.viewModel
                lifecycleOwner = this@StoresActivity
                recycleView.adapter = adapter
            }

        with(viewModel) {
            items.observe(this@StoresActivity, {
                adapter?.updateStores(it)
            })
            exposed.observe(this@StoresActivity, {

                adapter?.updateStores(it)
            })
        }
    }

    override fun inject() {
        DaggerStoresComponent.builder()
            .appComponent(InjectUtils.getComponent(applicationContext))
            .storesModule(StoresComponent.StoresModule(this, areaId))
            .build()
            .inject(this)
    }
}