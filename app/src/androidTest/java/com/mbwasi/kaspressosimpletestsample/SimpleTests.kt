package com.mbwasi.kaspressosimpletestsample

//import android.Manifest
//import androidx.test.rule.GrantPermissionRule
import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

/**
 * In this example you can observe a test tuned by default Kaspresso configuration.
 * When you start the test you can see output of default Kaspresso interceptors:
 * - a lot of useful logs
 * - failure handling
 * - screenshots in the device
 * * Also you can observe the test dsl simplifying a writing of any test
 */
class SimpleTest : TestCase() {
/*
(Tested on Android 33 Emulator)
This simple test works without requesting any permissions even though we are taking a screenshot and saving it on device.
This is because the screenshot is saved to Documents folder on device which does not require any special permission on modern android versions,
you might need permissions on older android versions in which case enable this and the permissions code in the manifest.
*/

//    @get:Rule
//    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
//        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//        Manifest.permission.READ_EXTERNAL_STORAGE
//    )

    @get:Rule
    val activityRule = activityScenarioRule<SimpleActivity>()

    @Test
    fun test() = run {

        step("Click button_1 and check button_2") {
            device.screenshots.take("Initial Screen state")
            SimpleScreen {
                button1 {
                    click()
                }
                button2 {
                    isVisible()
                }
            }
        }

        step("Click button_2 and check edit") {
            SimpleScreen {
                button2 {
                    click()
                }
                edit {
                    flakySafely(timeoutMs = 7000) { isVisible() }
                    hasText(R.string.simple_fragment_text_edittext)
                }
            }
        }

        step("Check all possibilities of edit") {
            scenario(
                CheckEditScenario()
            )
        }
    }
}
