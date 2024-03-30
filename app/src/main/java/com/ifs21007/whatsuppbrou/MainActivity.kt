package com.ifs21007.whatsuppbrou
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21007.whatsuppbrou.databinding.ActivityMainBinding
import com.ifs21007.whatsuppbrou.ui.ChattingFragment
import com.ifs21007.whatsuppbrou.ui.CommunitiesFragment
import com.ifs21007.whatsuppbrou.ui.LogcallFragment
import com.ifs21007.whatsuppbrou.ui.StatusFragment
import com.ifs21007.whatsuppbrou.ui.UpdatesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupAction()
    }
    private fun setupView() {
        loadFragment(FLAG_FRAGMENT_CHAT)
    }
    private fun setupAction() {
        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_updates -> {
                    loadFragment(FLAG_FRAGMENT_UPDATES)
                    true
                }
                R.id.navigation_calls -> {
                    loadFragment(FLAG_FRAGMENT_CALL)
                    true
                }
                R.id.navigation_communities -> {
                    loadFragment(FLAG_FRAGMENT_COMMUNITIES)
                    true
                }
                R.id.navigation_chats -> {
                    loadFragment(FLAG_FRAGMENT_CHAT)
                    true
                }
                R.id.navigation_settings -> {
                    loadFragment(FLAG_FRAGMENT_STATUS)
                    true
                }
                else -> true
            }
        }
    }
    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_CHAT -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_chats)
                    .setChecked(true)
                val chatFragment = ChattingFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        ChattingFragment.EXTRA_MESSAGE,
                        message ?: "Belum ada menu yang dipilih!"
                    )
                }
                chatFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        chatFragment,
                        ChattingFragment::class.java.simpleName
                    )
                    .commit()
            }
            FLAG_FRAGMENT_UPDATES -> {
                val updatesFragment = UpdatesFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(UpdatesFragment::class.java.simpleName)
                if (fragment !is UpdatesFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            updatesFragment,
                            UpdatesFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_CALL -> {
                val callFragment = LogcallFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(LogcallFragment::class.java.simpleName)
                if (fragment !is LogcallFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            callFragment,
                            LogcallFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_COMMUNITIES -> {
                val comunitiesFragment = CommunitiesFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(CommunitiesFragment::class.java.simpleName)
                if (fragment !is CommunitiesFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            comunitiesFragment,
                            CommunitiesFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_STATUS -> {
            val statusFragment = StatusFragment()
            val fragment = fragmentManager
                .findFragmentByTag(StatusFragment::class.java.simpleName)
            if (fragment !is StatusFragment) {
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        statusFragment,
                        StatusFragment::class.java.simpleName
                    )
                    .commit()
            }
        }
        }
    }
    companion object {
        const val FLAG_FRAGMENT_CHAT = "fragment_chatting"
        const val FLAG_FRAGMENT_CALL = "fragment_logcall"
        const val FLAG_FRAGMENT_COMMUNITIES = "fragment_communities"
        const val FLAG_FRAGMENT_UPDATES = "fragment_updates"
        const val FLAG_FRAGMENT_STATUS = "fragment_status"
    }
}