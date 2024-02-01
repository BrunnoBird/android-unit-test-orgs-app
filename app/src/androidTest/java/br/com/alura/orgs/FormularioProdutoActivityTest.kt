package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Test

class FormularioProdutoActivityTest {

    @Test
    fun deveMostrarCamposNecessariosParaCadastrarUmProduto() {
        launch(FormularioProdutoActivity::class.java)

        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {
        launch(FormularioProdutoActivity::class.java)

        onView(withId(R.id.activity_formulario_produto_nome)).perform(
            ViewActions.typeText("Banana"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(
            ViewActions.typeText("Banana nanica"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_valor)).perform(
            ViewActions.typeText("9.99"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(ViewActions.click())

        launch(ListaProdutosActivity::class.java)
        onView(withText("Banana"))
    }
}