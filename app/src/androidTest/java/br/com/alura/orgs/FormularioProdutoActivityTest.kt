package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Test

class FormularioProdutoActivityTest {

    // targetContext -> the real context of application
    // context -> the instrumentation test context
    @Before
    fun setupEnvironment() {
        AppDatabase.instancia(
            InstrumentationRegistry.getInstrumentation().targetContext
        ).clearAllTables()
    }

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
        launch(ListaProdutosActivity::class.java)

        onView(withId(R.id.activity_lista_produtos_fab)).perform(ViewActions.click())
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

    @Test
    fun deveSerCapazDeEditarUmProduto() {
        launch(ListaProdutosActivity::class.java)

        onView(withId(R.id.activity_lista_produtos_fab)).perform(ViewActions.click())
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
        onView(withText("Banana")).perform(ViewActions.click())
        onView(withId(R.id.menu_detalhes_produto_editar)).perform(ViewActions.click())
        onView(withId(R.id.activity_formulario_produto_nome)).perform(
            ViewActions.replaceText("Banana Nanica"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(
            ViewActions.replaceText("Banana colhidas de pequenos produtores"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_valor)).perform(
            ViewActions.replaceText("19.99"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(ViewActions.click())

        onView(withText("Banana nanica")).check(matches(isDisplayed()))
    }
}