package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.LoginActivity
import org.junit.Test

class LoginActivityTest {

    @Test
    fun deveMostrarNomeDoAplicativoQuandoEstaNaTelaDeLogin() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

    @Test
    fun deveTerTodosOsCamposNecessariosFazerLogin() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_entrar)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_cadastrar)).check(matches(isDisplayed()))
    }

    @Test
    fun devePreencherTodosOsCamposDeLoginEntrarNoApp() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.activity_login_usuario)).perform(
            ViewActions.typeText("massateste"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_login_senha)).perform(
            ViewActions.typeText("123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_login_botao_entrar)).perform(ViewActions.click())
    }
}