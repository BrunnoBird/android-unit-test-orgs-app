package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Before
import org.junit.Test

class CadastroUsuarioTeste {

    // targetContext -> the real context of application
    // context -> the instrumentation test context
    @Before
    fun setupEnvironment() {
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

    @Test
    fun deveCadastrarUsuario() {
        cadastraUsuario()
    }

    internal fun cadastraUsuario() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_usuario))
            .perform(
                ViewActions.typeText(
                    "massateste"
                ), ViewActions.closeSoftKeyboard()
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_email))
            .perform(
                ViewActions.typeText(
                    "massateste@email.com"
                ), ViewActions.closeSoftKeyboard()
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_senha))
            .perform(
                ViewActions.typeText(
                    "123456789"
                ), ViewActions.closeSoftKeyboard()
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())
    }
}