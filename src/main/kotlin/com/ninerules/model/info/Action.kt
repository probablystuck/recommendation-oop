package com.ninerules.model.info

import java.time.Instant

data class Action(
    val completed: Boolean,
    val dateCompleted: Instant
)