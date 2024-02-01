package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import br.com.alura.orgs.ui.activity.FormularioCadastroUsuarioActivity
import org.junit.Test

class FormularioCadastroUsuarioTest {

    @Test
    fun deveTerTodosOsCamposNecessariosFazerCadastro() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_usuario)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_email)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_senha)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_botao_cadastrar)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
    }

    @Test
    fun devePreencherCamposECadastrarUmUsuario() {
        launch(FormularioCadastroUsuarioActivity::class.java)

        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_usuario)).perform(
            ViewActions.typeText(
                "massateste"
            ), ViewActions.closeSoftKeyboard()
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_email)).perform(
            ViewActions.typeText(
                "massateste@email.com"
            ), ViewActions.closeSoftKeyboard()
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_senha)).perform(
            ViewActions.typeText(
                "123456789"
            ), ViewActions.closeSoftKeyboard()
        )
        onView(ViewMatchers.withId(R.id.activity_formulario_cadastro_botao_cadastrar)).perform(
            ViewActions.click()
        )
    }
}