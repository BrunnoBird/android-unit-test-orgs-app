package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Test

class ProdutoTelasTest {

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {
        launch(ListaProdutosActivity::class.java)
        Thread.sleep(1000L)
        clicaNoFAB()
        preencheCamposFormularioProduto(nome = "Banana", descricao = "Madura", valor = "9.99")
        onView(withText("Banana"))
    }

    @Test
    fun deveSerCapazDeEditarUmProduto() {
        launch(ListaProdutosActivity::class.java)
        Thread.sleep(1000L)
        onView(withText("Banana")).perform(ViewActions.click())
        onView(withId(R.id.menu_detalhes_produto_editar)).perform(ViewActions.click())
        preencheCamposFormularioProduto(
            nome = "Banana Nanica",
            descricao = "Banana colhidas de pequenos produtores",
            valor = "19.99"
        )
    }

    private fun preencheCamposFormularioProduto(
        nome: String,
        descricao: String,
        valor: String
    ) {
        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.replaceText(nome),
                ViewActions.closeSoftKeyboard()
            )
            .check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.replaceText(descricao),
                ViewActions.closeSoftKeyboard()
            )
            .check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.replaceText(valor),
                ViewActions.closeSoftKeyboard()
            )
            .check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar))
            .check(matches(isDisplayed()))
            .perform(ViewActions.click())
    }

    private fun clicaNoFAB() {
        onView(withId(R.id.activity_lista_produtos_fab)).perform(ViewActions.click())
    }
}