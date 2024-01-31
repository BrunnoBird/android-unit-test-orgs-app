package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Test

class ProdutoActivityTest {

    @Test
    fun deveMostrarONomeDoApp() {
        ActivityScenario.launch(ListaProdutosActivity::class.java)

        onView(withText("Orgs")).check(matches(isDisplayed()))
    }
}