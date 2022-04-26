package com.samsdk.myfirstproject.util

import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.model.Item
import com.samsdk.myfirstproject.model.Job

object ListObject {
    fun jobList(): List<Job> {
        return listOf(
            Job(
                R.drawable.al,
                "UX Designer",
                "Amazon",
                "Seattle, USA",
                "9 hour ago",
            ),
            Job(
                R.drawable.coinbase,
                "Product Designer",
                "CoinBase",
                "San Fransisco (Remote)",
                "9 hour ago"
            ),
            Job(
                R.drawable.figma,
                "Lead UX/UI Designer",
                "Figma",
                "London UK",
                "4 hour ago"
            ),
            Job(
                R.drawable.meta,
                "VR Designer",
                "Meta",
                "London UK (Remote)",
                "9 hour ago"
            ),
            Job(
                R.drawable.lamp,
                "UX/UI Designer",
                "Glovo",
                "Barcelona, Spain",
                "9 hour ago"
            ),
            Job(
                R.drawable.al,
                "UX Designer",
                "Amazon",
                "Seattle, USA",
                "9 hour ago",
            ),
            Job(
                R.drawable.coinbase,
                "Product Designer",
                "CoinBase",
                "San Fransisco (Remote)",
                "9 hour ago"
            ),
            Job(
                R.drawable.figma,
                "Lead UX/UI Designer",
                "Figma",
                "London UK",
                "4 hour ago"
            ),
            Job(
                R.drawable.meta,
                "VR Designer",
                "Meta",
                "London UK (Remote)",
                "9 hour ago"
            ),
            Job(
                R.drawable.lamp,
                "UX/UI Designer",
                "Glovo",
                "Barcelona, Spain",
                "9 hour ago"
            )
        )
    }

    fun itemList(): List<Item> {
        return listOf(
            Item(R.drawable.img1),
            Item(R.drawable.img2),
            Item(R.drawable.img3),
            Item(R.drawable.img5),
            Item(R.drawable.img6),
        )
    }
}