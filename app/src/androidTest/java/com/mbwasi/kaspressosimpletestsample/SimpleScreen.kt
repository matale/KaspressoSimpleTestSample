package com.mbwasi.kaspressosimpletestsample

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import com.kaspersky.kaspresso.screens.KScreen

//Defines the Screen and the views available to interact with during testing on the screen.
object SimpleScreen : KScreen<SimpleScreen>() {

    override val layoutId: Int = R.layout.activity_simple
    override val viewClass: Class<*> = SimpleActivity::class.java

    val button1 = KButton { withId(R.id.button_1) }

    val button2 = KButton { withId(R.id.button_2) }

    val edit = KEditText { withId(R.id.edit) }
}
