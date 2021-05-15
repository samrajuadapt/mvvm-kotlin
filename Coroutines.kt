package com.samboy.map.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Sam Raju on 5/1/21.
 */
object Coroutines {
   fun main(work:suspend (()->Unit)) = CoroutineScope(Dispatchers.Main).launch { work() }
}