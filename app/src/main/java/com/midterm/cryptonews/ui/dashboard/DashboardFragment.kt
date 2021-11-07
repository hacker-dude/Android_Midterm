package com.midterm.cryptonews.ui.dashboard

import android.view.View
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.FragmentDashboardBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import com.midterm.cryptonews.ui.dashboard.source.NewsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class DashboardFragment :
    BaseFragment<FragmentDashboardBinding, DashboardViewModel>(FragmentDashboardBinding::inflate) {
    private lateinit var usersAdapter: NewsAdapter

    override fun init() {
        binding.progressBar.visibility = View.VISIBLE
        binding.srlNewsRefresher.isRefreshing = true
        initUsersRecyclerView()
        setObservers()
        listeners()
        binding.progressBar.visibility = View.GONE
    }

    private fun listeners(){
        binding.btnProfile.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)
        }

        binding.btnList.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_coinListFragment)
        }
        binding.srlNewsRefresher.setOnRefreshListener {
            usersAdapter.refresh()
        }
    }
    private fun initUsersRecyclerView() {
        binding.newsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            usersAdapter = NewsAdapter()
            adapter = usersAdapter
        }
    }

    private fun setObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usersFlow().collectLatest { pagingData ->
                binding.srlNewsRefresher.isRefreshing = false
                usersAdapter.submitData(pagingData)
            }
        }
    }
    override var useViewModelFactory = true
    override fun getFactory(): ViewModelProvider.Factory = DashboardViewModelFactory(Repository())

    override fun getViewModel(): Class<DashboardViewModel> =
        DashboardViewModel::class.java

}