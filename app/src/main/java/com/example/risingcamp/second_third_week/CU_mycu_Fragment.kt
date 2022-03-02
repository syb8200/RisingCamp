package com.example.risingcamp.second_third_week

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.risingcamp.R

class CU_mycu_Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mycu, container, false)

        val cu_membership = view.findViewById<LinearLayout>(R.id.cu_membership)

        cu_membership.setOnClickListener{ view->
            val intent = Intent(activity, CU_membership_card::class.java)
            startActivity(intent)
        }


        return view
    }
}